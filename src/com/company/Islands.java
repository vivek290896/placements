package com.company;

import java.util.ArrayList;
import java.util.Collections;

class Islands {

    static ArrayList<ArrayList<Boolean>> visited;

    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        visited = new ArrayList<>();
        ArrayList<Boolean> list1 = new ArrayList<>(M);
        for(int i=0;i<M;i++){
            list1.add(false);
        }
        Collections.fill(list1,false);
        for(int i=0;i<N;i++){
            visited.set(i,list1);
        }

        System.out.println();
        int count = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(!visited.get(i).get(j)) {
                    count += DFS(list,N,M,i,j);
                }
            }
        }
        return count;
    }

    static int DFS(ArrayList<ArrayList<Integer>> list,int N, int M, int i,int j){

        if(i< 0 || i > N || j < 0 || j > M
                || visited.get(i).get(j)
                || list.get(i).get(j) == 0) return 0;


        if(list.get(i).get(j) == 1) {
            visited.get(i).set(j, true);
            DFS(list,N,M,i+1,j);
            DFS(list,N,M,i+1,j+1);
            DFS(list,N,M,i-1,j);
            DFS(list,N,M,i-1,j-1);
            DFS(list,N,M,i,j+1);
            DFS(list,N,M,i,j-1);
            DFS(list,N,M,i-1,j+1);
            DFS(list,N,M,i+1,j-1);
        }
        return 1;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(3);
        ArrayList<Integer> list1 = new ArrayList<>(3);
        for (int i=0;i<3;i++) list1.add(0);
        for(int i=0;i<3;i++){
            list.add(list1);
        }
//        list.get(0).set(0,1);
        list.get(0).set(2,1);
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++)
                System.out.print(list.get(i).get(j)+ " ");
            System.out.println();
        }
    }

}
