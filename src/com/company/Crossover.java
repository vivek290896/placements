package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Crossover {

    static class AntiPattern {

        public static void main(String[] a) {

        }

        static String readLine(String path) throws IOException {
            try (BufferedReader br =
                         new BufferedReader(new FileReader(path))) {
                return br.readLine();
            }
        }
    }
}
