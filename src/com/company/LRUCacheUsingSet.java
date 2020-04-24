package com.company;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCacheUsingSet {

    static Set<Integer> cache;
    static int capacity;

    LRUCacheUsingSet(int x){
        cache = new LinkedHashSet<>(x);
        capacity = x;
    }

    static void display()
    {
        Iterator<Integer> itr = cache.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    static boolean get(int x){
        if(!cache.contains(x))
            return false;
        cache.remove(x);
        cache.add(x);
        return true;
    }

    static void put(int x){
        if (cache.contains(x))
            cache.remove(x);
        if (cache.size() == capacity){
            int first = cache.iterator().next();
            cache.remove(first);
        }
        cache.add(x);
    }

    static void refer(int x){
        if(!get(x)) put(x);
    }

    public static void main(String[] args){
        LRUCacheUsingSet cacheUsingSet = new LRUCacheUsingSet(4);
        refer(1);
        refer(2);
        refer(3);
        refer(1);
        refer(4);
        refer(5);
        display();
    }
}
