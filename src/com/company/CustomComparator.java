package com.company;

import java.util.Comparator;

public class CustomComparator {
    private String name;
    private int rollNo;
    private int studentAge;

    public CustomComparator(String name, int rollNo, int studentAge) {
        this.name = name;
        this.rollNo = rollNo;
        this.studentAge = studentAge;
    }

    public static Comparator<CustomComparator> studentNameCompare = new Comparator<CustomComparator>() {
        @Override
        public int compare(CustomComparator s1, CustomComparator s2) {
            String name1 = s1.getName().toUpperCase();
            String name2 = s2.getName().toUpperCase();
            //for assending order
            return name1.compareTo(name2);

            //for descending order
            ///return name2.compareTo(name1);
        }
    };

    //Now the above method can be called like ==>
    // Collections.sort(arrayList, CustomComparator.studentNameCompare);

    public String getName(){
        return this.name;
    }
}
