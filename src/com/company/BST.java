package com.company;

public class BST {

    public static void main(String[] a){
        Node bst = BSTUtility.createBST();
        TreeTraversal.inorderTraversal(bst);
    }
}
