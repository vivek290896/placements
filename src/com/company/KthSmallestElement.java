package com.company;

import java.util.Random;

public class KthSmallestElement {

    static int findKthSmallestElement(int[] arr, int l,int r,int k){

        if(k>0 && k<= r-l+1){

            int pos = randomPartition(arr,l,r);

            if(pos-1 == k-1){
                return arr[pos];
            }
            if(pos-1 > k-1)
                return findKthSmallestElement(arr,l,pos-1,k);

            return findKthSmallestElement(arr,pos+1,r,k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }
    static int partition(int[] arr, int l,int r){
        int x = arr[r], i = l;
        for(int j=l;j<=r-1;j++){
            if(arr[j] <= x){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }
    static void swap(int[] arr, int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    static int randomPartition(int[] arr, int l,int r){
        int pivot = new Random().nextInt(1);
        swap(arr,l+pivot,r);
        return partition(arr,l,r);
    }

    public static void main(String[] args){

        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int length = arr.length;
        int k = 3;
        System.out.println(findKthSmallestElement(arr,0,length-1,k));
    }
}
