package com.company;

import java.io.*;
import java.util.HashMap;

public class SerializeMap {

    public static void main(String[] a){
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        //Adding elements to HashMap
        hmap.put(11, "AB");
        hmap.put(2, "CD");
        hmap.put(33, "EF");
        hmap.put(9, "GH");
        hmap.put(3, "IJ");
        FileOutputStream fi = null;
        ObjectOutputStream ou = null;
        try {
            fi = new FileOutputStream("hmap.ser");
            ou = new ObjectOutputStream(fi);
            ou.writeObject(hmap);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                fi.close();
                ou.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
