package com.company;

import java.util.ArrayList;
import java.util.Spliterator;

public class split {

    public static void main(String[] a){
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(1.0); arr.add(4.0);arr.add(16.0);
        Spliterator<Double> spliterator = arr.spliterator();
        while(spliterator.tryAdvance((n) -> System.out.print(" "+ n)));
        System.out.println();
        spliterator = arr.spliterator();
        ArrayList<Double> sq = new ArrayList<>();
        while (spliterator.tryAdvance((n)-> sq.add(Math.sqrt(n))));
        spliterator = sq.spliterator();
        spliterator.forEachRemaining((n)-> System.out.print(" "+n));
    }
}
