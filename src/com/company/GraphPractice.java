package com.company;

import java.util.*;

public class GraphPractice {

    static void init(boolean[] visited){
        for(int i=0;i< visited.length;i++){
            visited[i] = false;
        }
    }


    static void BFS(int s, Graph g){
        boolean visited[] = new boolean[g.V];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        while (!queue.isEmpty()){
            int element = queue.poll();
            visited[element] = true;
            System.out.print(element+" ");
            g.adj[element].forEach(x -> {
                if (!visited[x]){
                    queue.add(x);
                }
            });
        }
    }

    static void DFS(int source, Graph graph, boolean visited_DFS[]){
        visited_DFS[source] = true;
        System.out.print(source+ "");
        graph.adj[source].forEach(node ->{
            if (!visited_DFS[node]) DFS(node,graph,visited_DFS);
        });
    }

    public static void main(String[] a){
        Graph g = Graph.create();
        int source = 2;
        BFS(source,g);

        System.out.println("DFS");
        boolean visited_DFS[] = new boolean[g.V];
        init(visited_DFS);
        DFS(source,g,visited_DFS);
    }
}
