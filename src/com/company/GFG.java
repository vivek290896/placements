package com.company;

import javafx.util.Pair;

import java.util.*;

public class GFG {

    static class minSwap{
        public static int minSwaps(int[] a, int n)
        {
            HashMap<Integer,Integer> edgeMapping = new HashMap<>();
            for(int i=0;i<n;i++){
                int count = 0;
                for(int j=0;j<n;j++){
                    if(a[i] > a[j]){
                        count++;
                    }
                }
                edgeMapping.put(i,count);
            }

            boolean[] visited = new boolean[n];
            for(int i=0;i<n;i++) visited[i] = false;

            return cycleCount(edgeMapping,visited,n);
        }

        static int cycleCount(HashMap<Integer,Integer> edgeMapping, boolean[] visited,int n){
            int minSwap = 0;
            for(int i=0;i<n;i++){
                int count = 1;
                if (visited[i]) continue;
                visited[i] = true;
                int index = edgeMapping.get(i);
                while (!visited[index]){
                    visited[index] = true;
                    index = edgeMapping.get(index);
                    count++;
                }
                minSwap += count-1;
            }
            return minSwap;
        }

    }

    static class Solution
    {
        static void init(boolean visited[][],int m,int n){
            for(int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    visited[i][j] = false;
                }
            }
        }
        public String[] wordBoggle(char board[][], String[] dictionary)
        {

            String[] finalList = new String[dictionary.length];
            int count = 0;
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i=0;i<dictionary.length;i++){
                String word = dictionary[i];
                init(visited,m,n);
                if (findWord(board,word,0,visited,0,0,m,n)){
                    finalList[count++] = word;
                    System.out.println(word);
                }
            }
            List<String> newlist = new ArrayList<>();
        return finalList;
        }

        static boolean findWord(char board[][],String word,int wordIndex, boolean[][] visited,int x,int y,int m,int n){
            if(x < 0 || x >= m || y < 0 || y >= n
                    || wordIndex >= word.length() || word.charAt(wordIndex) != board[x][y]
                    || visited[x][y]) return false;

            visited[x][y] = true;

            if (board[x][y] == word.charAt(wordIndex) && wordIndex == word.length()-1) return true;

            for (int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++)
                    if(findWord(board,word, wordIndex+1,visited,i,j,m,n)) return true;
            }
             return false;
        }
    }
}
