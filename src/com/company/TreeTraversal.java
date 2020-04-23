package com.company;

public class TreeTraversal {

    static void inorderTraversal(Node root){
        if (root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.key+ " ");
        inorderTraversal(root.right);
    }

}
