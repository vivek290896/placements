package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class BackTracking {

    static class RatInAMaze {
        static ArrayList<String> all_paths;

        static void init() {
            all_paths = new ArrayList<>();
        }

        static int[][] createMaze() {
            int[][] maze = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 1, 0},
                    {1, 1, 1, 1}};
            return maze;
        }

        private static void solveMaze(int[][] maze, int n, int i, int j, String path) {

            if (i < 0 || j < 0 || i > n - 1 || j > n - 1 || maze[i][j] == 0 || maze[i][j] == 100) return;

            if (i == n - 1 && j == n - 1) {
                all_paths.add(path);
                return;
            }

            maze[i][j] = 100; // mark as visited
            solveMaze(maze, n, i + 1, j, path + "D");
            solveMaze(maze, n, i, j + 1, path + "R");
            solveMaze(maze, n, i - 1, j, path + "U");
            solveMaze(maze, n, i, j - 1, path + "L");

            maze[i][j] = 1; // mark as unvisited for other paths
            return;
        }

        static void printPaths() {
            all_paths.forEach(path -> System.out.println(path));
        }

        public static void main(String[] a) {
            int[][] maze = createMaze();
            int length = maze.length;
//        System.out.println("length is: "+ length);
            init();
            solveMaze(maze, length, 0, 0, "");
            printPaths();
        }
    }

    static class N_Queens{

        static int[][] board;
        static int n;

        static void init(){
            board = new int[n][n];
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    board[i][j] = 0;
        }

        static boolean solve_board(int column){
            if (column == n) return true;

            for (int row = 0;row<n;row++){
                if (isSafe(row,column)){
                    board[row][column] = 1;
                    if(!solve_board(column+1)){
                        board[row][column] = 0;
                    } else return true;
                }
            }
            return false;
        }

        static boolean isSafe(int row, int column){
            for (int i=0;i<column;i++){
                if (board[row][i] == 1) return false;
            }
            for (int i=row,j=column;i>=0&&j>=0; i--,j--){
                if (board[i][j] == 1) return false;
            }
            for (int i=row,j=column;i<n&&j>=0;i++,j--){
                if (board[i][j] == 1) return false;
            }
            return true;
        }

        static void print_board(){
            for (int i=0;i<n;i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }

        public static void main(String[] a){
            n = 4;
            init();
            if (solve_board(0)){
                System.out.println("board solved");
                print_board();
            }
        }
    }

    static class allPossibleSubsets{
        static HashSet<String> all_subsets;
        static int n;

        static void init(){
            all_subsets = new HashSet<>();
        }

        static void printAllSets(){
            all_subsets.forEach(set -> System.out.println(set+ " "));
        }

        static void findSubsets(ArrayList<String> list, int index,ArrayList<String> temp){
            String str = "";
            str = temp.toString();
            all_subsets.add(str);
            for (int i = index;i<n;i++){
                temp.add(list.get(i));
                findSubsets(list,i+1,temp);
                temp.remove(list.get(i));
            }
            return;
        }

        public static void main(String[] a){
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> temp = new ArrayList<>();
            n = 3;
            init();
            list.add("1");
            list.add("2");
            list.add("3");
            findSubsets(list,0,temp);
            printAllSets();
        }
    }

    static class sudoku{
        static int row,column,n;
        static int[][] sudoku;

        static void init() {
            sudoku = new int[][]
                    {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                    };
        }

        static boolean solve(){
            if (isComplete()) return true;

            for (int i=1;i<=n;i++){
                if (isSafe(i)){
                    sudoku[row][column] = i;
                    if (solve()) return true;
                    sudoku[row][column] = 0;
                }
            }
            return false;
        }
        static boolean isComplete(){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (sudoku[i][j] == 0) {
                        row = i; column = j;
                        return false;
                    }
                }
            }
            return true;
        }

        static void printSudoku(){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    System.out.print(sudoku[i][j]+ " ");
                }
                System.out.println();
            }
        }
        static boolean isSafe(int value){
           return isSafeRow(value) && isSafeColumn(value) && isSafeBox(value) ;
        }

        static boolean isSafeRow(int value){
            for(int i=0;i<n;i++){
                if(sudoku[row][i] == value) return false;
            }
            return true;
        }
        static boolean isSafeColumn(int value){
            for(int i=0;i<n;i++){
                if(sudoku[i][column] == value) return false;
            }
            return true;
        }

        static boolean isSafeBox(int value){
            int row_Start = (int)(row - row%Math.sqrt(n));
            int sudokuEnd = (int)Math.sqrt(n);
            int columnStart = (int)(column - column%Math.sqrt(n));
            for (int i=row_Start;i<row_Start+ sudokuEnd; i++){
                for (int j=columnStart;j< columnStart + sudokuEnd; j++) {
                    if (sudoku[i][j] == value) return false;
                }
            }
            return true;
        }

        public static void main(String[] a){
            n = 9;
            init();
            solve();
                printSudoku();
        }
    }
}
