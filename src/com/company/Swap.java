package com.company;

public class Swap {
    public static void swap(final int x, final int y) {
        int tempX = x;
        int tempY = y;
        // swapping
        int temp = tempX;
        tempX = tempY;
        tempY = temp;
        // now x and y parameters values have not been changed
        System.out.println("x(1) = " + x);
        System.out.println("y(1) = " + y);
    }
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        swap(x, y);
        System.out.println("x(2) = " + x);
        System.out.println("y(2) = " + y);
    }
}