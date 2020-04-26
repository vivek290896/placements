package com.company;

import java.util.LinkedList;

public class Graph {
    public int V;
    public LinkedList<Integer> adj[];

    private void addEdge(int v, int w){
        adj[v].add(w);
    }

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    static Graph create(){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        return g;
    }
}
