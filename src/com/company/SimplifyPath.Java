package com.company;
import java.io.*;
import java.util.*;

public class SimplifyPath {
	public static void main(String[] a) {
		String path = "/home//c"; // failed test case: "/a/./b/../../c/" -->expected /c
		// failed case not understood: "/b/../a/../d/../c/home/../q" -->expected: /c/q  why ??
		System.out.println(simplifyPath(path));
	}

	public static String simplifyPath(String path){ 
        Stack<Character> canonic = new Stack<>();
        String result = "";
        canonic.push(path.charAt(0));
        for (int i=1; i< path.length();i++) {
            if (path.charAt(i) == '.') {
                continue;
            }
            if (path.charAt(i) == '/' && canonic.peek() == '/') {
                continue;
            }
            if (i == path.length()-1 && path.charAt(i) == '/') {
                continue;
            }
            canonic.push(path.charAt(i));
        }
        Iterator<Character> itr = canonic.iterator();
        while(itr.hasNext()) {
            result += itr.next().toString();
        }
        return result;
    }	
}