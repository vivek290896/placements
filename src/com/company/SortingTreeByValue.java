package com.company;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortingTreeByValue {

    static <K,V extends Comparable<V>> Map<K,V> sortByValues(final Map<K, V> map){
        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                int compareValue = map.get(o1).compareTo(map.get(o2));
                return compareValue == 0 ? 1: compareValue;
            }
        };

        Map<K,V> sortedByValue = new TreeMap<>(valueComparator);
        sortedByValue.putAll(map);
        return sortedByValue;
    }

    public static void main(String args[]) {

        TreeMap<String, String> treemap = new TreeMap<String, String>();

        // Put elements to the map
        treemap.put("Key1", "Jack");
        treemap.put("Key2", "Rick");
        treemap.put("Key3", "Kate");
        treemap.put("Key4", "Tom");
        treemap.put("Key5", "Steve");

        // Calling the method sortByvalues
        Map sortedMap = sortByValues(treemap);

        // Get a set of the entries on the sorted map
        sortedMap.forEach((K,V) -> {
            System.out.println("key: "+K+ " value: "+ V);
        });
    }
}
