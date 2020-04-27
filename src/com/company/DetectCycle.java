package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {
    public static class Graph{
        int V;
        List<List<Integer>> adj;

        Graph(int nodes){
            this.V = nodes;
            adj = new ArrayList<>(nodes);
            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }

        void addEdge(int v,int w){
            adj.get(v).add(w);
        }

        void addEdgeUndirected(int v,int w){
            adj.get(v).add(w);
            adj.get(w).add(v);
        }
        boolean hasCycleUndirected(int node, boolean[] visited, int parent){
            visited[node] = true;

            Iterator<Integer> iterator = this.adj.get(node).iterator();
            while (iterator.hasNext()){
                int value = iterator.next();

                if (!visited[value]){
                    if(hasCycleUndirected(value,visited,node)) return true;
                } else if (value != parent) return true;
            }
            return  false;
        }

        Boolean isCyclic()
        {
            // Mark all the vertices as not visited and not part of
            // recursion stack
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in
            // different DFS trees
            for (int u = 0; u < V; u++)
                if (!visited[u]) // Don't recur for u if already visited
                    if (hasCycleUndirected(u, visited, -1))
                        return true;

            return false;
        }

    }
    static boolean hasCycle(Graph g,int i, boolean[] visited, boolean[] recStack){

        if (recStack[i]) return true;
        if (visited[i]) return false;

        recStack[i] = true;
        visited[i] = true;

        List<Integer> children = g.adj.get(i);
        for (Integer child : children) {
            if (hasCycle(g, child, visited, recStack))
                return true;
        }

        recStack[i] = false;
        return false;
    }

    static void detectCycle(Graph g){
        boolean[] visited = new boolean[g.V];
        boolean[] recStack = new boolean[g.V];

        for (int i=0;i<g.V;i++){
            if (hasCycle(g,i,visited,recStack)) {
                System.out.println("Cycle found");
                break;
            }
        }
    }


    public static void main(String[] a){
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        detectCycle(graph);

        if (graph.isCyclic()) System.out.println("bla");
    }


}
