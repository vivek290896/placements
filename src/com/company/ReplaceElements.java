package com.company;

import java.util.*;

public class ReplaceElements {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        vector.add("Harry");
        vector.add("Steve");
        vector.add("Vince");
        vector.add("David");
        vector.add("Matt");

        System.out.println("Vector elements before replacement: ");
        for(int i=0; i < vector.size(); i++)
        {
            System.out.println(vector.get(i));
        }

        //Replacing index 1 element
        vector.set(1,"Mark");
        //Replacing index 2 element
        vector.set(2,"Jack");

        System.out.println("Vector elements after replacement: ");
        for(int i=0; i < vector.size(); i++)
        {
            System.out.println(vector.get(i));
        }
    }

}
