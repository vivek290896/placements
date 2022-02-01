package com.company;
import java.io.*;
import java.util.*;

public class SimplifyPath {
	public static void main(String[] a) {
		String path = "/home//c";
		path = "/home/./a/../c/q";
		System.out.println(simplifyPath2(path));
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
    public static String simplifyPath2(String path) {
    	Deque<String> stack = new LinkedList<>();
    	for (String atr: path.split("/")) {
    		if (atr.equals("..")) stack.poll();
    		else if (!atr.equals(".") && !atr.equals("")) stack.push(atr);
    	}
    	StringBuilder res = new StringBuilder();
    	if (stack.size() == 0) return "/";
    	while(stack.size() != 0) res.append("/").append(stack.pollLast());
    	return res.toString();
    }
}