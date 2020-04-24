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

    static Node createTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    static int findDistanceBetweenTwoNodes(Node root, Node n1, Node n2){
        if(root == null) return 0;
        Node lca = LowestCommonAncestor.findLCA(n1,n2,root);
        return findLevel(lca,n1,0) + findLevel(lca,n2,0);
    }

    static int findLevel(Node n1, Node n2,int len){
        if (n1 == null) return -1;
        if(n1.key == n2.key) return len;
        int l = findLevel(n1.left,n2,len+1);
        int r = findLevel(n1.right,n2,len+1);
        return l != -1 ? l : r;
    }

}
