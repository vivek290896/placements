package com.company;

public class interviewr {

    public static void main(String[] a){
        int[] arr = {11,16,12,12,12,13,14,15};
        int[] arr2 = {11,16,10,9,12,14,15,13};
        int[] arr3 = {11,10,13,9,14};
        int[] arr4 = {-4,-3,-2,-1,0,1};
        int n = arr.length;
        System.out.println(function2(arr,n));
        System.out.println(function2(arr2,arr2.length));
        System.out.println(function2(arr3,arr3.length));

    }

    static boolean function2(int[] arr, int n){
        int min=Integer.MAX_VALUE, sum=0;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if(min > arr[i])
                min=arr[i];
            if(arr[i] > max)
                max=arr[i];
            sum+=arr[i];
        }
        min--;
        int s1 = max * (max + 1) / 2;
        int s2 = min * (min + 1) / 2;
//        System.out.println("sum1=" + sum + "sum2=" + (s1-s2));
        if((s1-s2) == sum)
            return true;
        return false;
    }

   static boolean function(int[] arr, int n){

        int max = -1000;
        int min = 1000;

        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int var  = max - min+1;

        if(var > n) return false;

        boolean hasVisited[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(hasVisited[arr[i]-min] == true) return false;
            hasVisited[arr[i]-min] = true;
        }
        for(int i=0;i<var;i++){
            if(hasVisited[i] == false){
                return false;
            }
        }
        return  true;
    }

}
