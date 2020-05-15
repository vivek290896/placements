package com.company;

import java.util.Stack;

public class vmWare {


    void printSpiral(Node root){
        String a = Hello.getValue();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                Node x = s1.pop();
                System.out.print(x.key+ " ");
                if(x.right != null) s2.push(x.right);
                if(x.left != null) s2.push(x.left);
            }

            while (!s2.isEmpty()){
                Node x = s2.pop();
                System.out.print(x.key+ " ");
                if(x.left != null) s1.push(x.left);
                if(x.right != null) s1.push(x.right);
            }
        }
    }

    void printCurrentLevel(Node node,int i, boolean toR){}

    void printSpiralRec(Node root){
        int height = 3;

        int i;

        boolean toR = false;

        for(i= 1;i<height;i++) {
            printCurrentLevel(root,i,toR);

            toR  = !toR;
        }
    }

    int findMax(int a[],int size){ //-2 , -3 ,4 ,-1 ,-2 ,-4,1,5,8,-3
        int result = -100000;
        String x = "vivek";
        Character.toUpperCase(x.charAt(0));

        int maximumFound = 0;
        int start=0,end=0,c=0;

        for(int i=0;i<size;i++){
            maximumFound += a[i];

            if(result < maximumFound) {
                result = maximumFound;
                start = c;
                end = i;
            }

            if (maximumFound <0) {
                maximumFound = 0;
                c = i+1;
            }
        }
        System.out.println(start+ "strt: ->end"+ end);
        return result;
    }

    public static void main(String[] args){
        System.out.println(Hello.value);
    }

}
