package com.company;

public class TreeTraversal {

    static void inorderTraversal(Node root){
        if (root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.key+ " ");
        inorderTraversal(root.right);
    }

    static void preOrderTraversal(Node root){
        if (root == null) return;

        System.out.print(root.key+ " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.key+ " ");
    }
}
