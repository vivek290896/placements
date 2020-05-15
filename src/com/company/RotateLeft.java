package com.company;

public class RotateLeft {

    public static void main(String[] args) {
	    int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	    int d = 3;
        RotateLeft rotateLeftClass = new RotateLeft();
        rotateLeftClass.left_rotate(arr,d,arr.length);
        Utility.printArray(arr,arr.length);
    }

    public int g_c_d(int a, int b){
        if (b == 0)
            return a;
        else return g_c_d(b,a%b);
    }


    public void left_rotate(int arr[], int d, int n){
        int gcd = g_c_d(d,n);
        int temp,j,k;
        for(int i=0; i < gcd; i++){
            temp =  arr[i];
            j = i;
            while (true){
                k = j+d;
                if(k >= n)
                    k = k-n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j=k;
            }
            arr[j] = temp;
        }
    }
}
