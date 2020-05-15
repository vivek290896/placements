package com.company;

// Java Code to sort 2D Matrix
// according to any Column
import java.util.*;
class SortCheck {

    // Function to sort by column
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        }); // End of function call sort().
        int[] ar = new int[10];
//        Arrays.parallelSort(arr,);
    }

    public static void sortInRange(int[][] arr, int start,int end, int col){
        Arrays.parallelSort(arr, start, end, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    // Driver Code
    public static void main(String args[])
    {
        int matrix[][] = { { 39, 27, 11, 42 },
                { 10, 93, 5, 90 },
                { 54, 78, 56, 89 },
                { 24, 64, 9, 65 } };
        // Sort this matrix by 3rd Column
        int col = 3;
        sortbyColumn(matrix, col);
//        sortbyColumn(matrix, col - 1);
        sortInRange(matrix,0,2,2);
        // Display the sorted Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }


    }
}
