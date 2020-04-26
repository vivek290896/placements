package com.company;

import java.util.ArrayList;
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
    }


}
