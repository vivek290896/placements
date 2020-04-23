package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderInsertion {

    Node root;
    static void inorderTraverse(Node temp){
        if(temp == null) return;

        inorderTraverse(temp.left);
        System.out.print(temp.key+" ");
        inorderTraverse(temp.right);
    }

    static void insert(Node temp, int key){
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        while (!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = new Node(key);
                break;
            } else q.add(temp.left);
            if (temp.right == null){
                temp.right = new Node(key);
                break;
            } else q.add(temp.right);
        }
    }

    public static void main(String[] args){
        LevelOrderInsertion levelOrderInsertion = new LevelOrderInsertion();
        levelOrderInsertion.root = new Node(10);
        levelOrderInsertion.root.left = new Node(11);
        levelOrderInsertion.root.left.left = new Node(7);
        levelOrderInsertion.root.right = new Node(9);
        levelOrderInsertion.root.right.left = new Node(15);
        levelOrderInsertion.root.right.right = new Node(8);
        System.out.println("Before");
        inorderTraverse(levelOrderInsertion.root);

        insert(levelOrderInsertion.root,12);
        System.out.println("after");
        inorderTraverse(levelOrderInsertion.root);

    }
}
