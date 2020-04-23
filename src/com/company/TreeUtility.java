package com.company;

public class TreeUtility {

    static Node findRightMostNode(Node root){
        if(root == null) return root;
        if (root.left == null && root.right == null) return root; //leaf node
        if(root.right == null) return findRightMostNode(root.left);
        return findRightMostNode(root.right);
    }
    static void deleteRightMost(Node root, Node rightMost){
        if(root == null) return;
        deleteRightMost(root.left,rightMost);
        deleteRightMost(root.right,rightMost);

        if(root.right == rightMost)  root.right = null;
        else if(root.left == rightMost) root.left = null;
    }

    static Node findNodeByKey(Node root, int key){
        if (root == null || root.key == key) return root;
        Node l = findNodeByKey(root.left,key);
        Node r = findNodeByKey(root.right,key);
        return l != null ? l : r;
    }
}
