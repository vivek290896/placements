package com.company;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    static Deque<Integer> dq;
    static HashSet<Integer> map;

    static int cache_size;

    LRUCache(int n){
        dq = new LinkedList<>();
        map = new HashSet<>();
        cache_size = n;
    }

    static void refer(int x){
        if (!map.contains(x)){
            if (dq.size() == cache_size) {
                int last = dq.removeLast();
                map.remove(last);
            }
        } else {
            dq.remove(x);
        }
        dq.push(x);
        map.add(x);
    }

    static void display(){
        Iterator<Integer> iterator = dq.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(4);
        refer(1);
        display();
        refer(2);
        display();
        refer(3);
        display();
        refer(1);
        display();
        refer(4);
        display();
        refer(5);
        display();
        refer(1);
        display();
    }
}
