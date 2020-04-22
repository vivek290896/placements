package com.company;

public class Reversal {

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5};
        Reversal reversal = new Reversal();
        reversal.reverse(arr,0,arr.length-1);
        Utility.printArray(arr,arr.length);
    }

    public void reverse(int[] arr,int start,int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
