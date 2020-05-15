package com.company;

public class BSTinRotation {

    public static void main(String[] a){
        int[] arr = {9, 10 ,12, 14, 17, 4, 5};
        int[] b = {14, 17, 4, 5, 6, 10, 12};
        int[] c = {4, 5, 9, 10, 12, 14, 17};
        int[] d = {1,0,1,1,1,1,1,1,1,1};

        System.out.println(searchInRotation(d,0,d.length-1,0));
    }

    static int searchInRotation(int[] arr,int start,int end, int key){
        if(start > end) return -1;

        int m = (start+end)/2;
        if(arr[m] == key) return m;

        if(arr[start] <= arr[m]){
            if(key >= arr[start] && key <= arr[m]){
                return searchInRotation(arr, start, m-1,key);
            }
            return searchInRotation(arr,m+1,end,key);
        }
        if(key >= arr[m] && key <= arr[end]){
            return searchInRotation(arr,m+1,end,key);
        }

        return searchInRotation(arr, start, m-1,key);
    }

}
