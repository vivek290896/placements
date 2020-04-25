package com.company;

public class BST_pred_succ {
    static Node pred=null, succ=null;

    static void find_pred_succ(Node root,int key){
        if (root == null) return;

        find_pred_succ(root.left,key);

        if (key > root.key && (pred ==null || pred.key < root.key))
            pred = root;
        if (key < root.key && (succ == null || succ.key > root.key))
            succ = root;

        find_pred_succ(root.right,key);
    }

    public static void main(String[] a){
        Node bst = BSTUtility.createBST();
        TreeTraversal.inorderTraversal(bst);
        int key = 5;
        find_pred_succ(bst,key);
        System.out.println("pred: "+ pred.key + " succ: "+ succ.key);

        Node lcm = BSTUtility.find_LCM_BST(bst,2,7);
        System.out.println("LCM: "+ lcm.key);
    }
}
