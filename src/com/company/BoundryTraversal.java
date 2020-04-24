package com.company;

public class BoundryTraversal {

    static void traversal(Node root){
        if (root == null) return;
        System.out.print(root.key+ " ");
        printLeft(root.left);
        printLeaf(root.left);
        printLeaf(root.right);
        printRight(root.right);
    }

    static void printLeft(Node root){
        if(root == null ||
                (root.left == null && root.right == null)) return;
        System.out.print(root.key+ " ");
        if (root.left != null)
            printLeft(root.left);
        else
            printLeft(root.right);
    }
    static void printLeaf(Node root){
        if (root == null) return;
        printLeaf(root.left);
        if (root.left == null && root.right == null)System.out.print(root.key+ " ");
        printLeaf(root.right);
    }
    static void printRight(Node root){
        if (root == null ||
                (root.left == null && root.right == null)) return;
        if (root.right != null)
            printRight(root.right);
        else
            printRight(root.left);
        System.out.print(root.key+ " ");
    }

    public static void main(String[] args){
        Node root = TreeUtility.createTree();
        traversal(root);
    }
}
