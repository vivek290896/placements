package com.company;

public class BSTUtility {

    static Node insert(Node root,int key){
        if (root == null) return new Node(key);
        if (key <= root.key)
           root.left = insert(root.left, key);
        else
            root.right = insert(root.right,key);
        return root;
    }

    static Node createBST(){
        Node bst = new Node(5);
        insert(bst,2);
        insert(bst,4);
        insert(bst,3);
        insert(bst,1);
        insert(bst,7);
        insert(bst,6);
        insert(bst,8);
        return bst;
    }
}
