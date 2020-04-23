package com.company;

import java.util.LinkedList;
import java.util.Queue;
import static com.company.TreeUtility.*;

public class DeletionBT {
    Node root;

    static void deleteNode(Node root,int key, Node rightMost){
        Queue<Node> q = new LinkedList<Node>();

        q.add(root);

        while (!q.isEmpty()){
            Node temp = q.peek();
            q.remove();

            if (temp.key == key) {
                temp.key = rightMost.key;
                break;
            }
        }
    }

    public static void main(String[] args){
        DeletionBT deletionBT = new DeletionBT();

        deletionBT.root = new Node(10);
        deletionBT.root.left = new Node(11);
        deletionBT.root.left.left = new Node(7);
        deletionBT.root.left.right = new Node(12);
        deletionBT.root.right = new Node(9);
        deletionBT.root.right.left = new Node(15);
        deletionBT.root.right.right = new Node(8);

        System.out.println("inorder traversal");
        TreeTraversal.inorderTraversal(deletionBT.root);

        Node rightMost = findRightMostNode(deletionBT.root);

        Node toBeReplaced = findNodeByKey(deletionBT.root,12);
        //replace key with rightmost and then
        toBeReplaced.key = rightMost.key;

        deleteRightMost(deletionBT.root,rightMost);
        System.out.println("after");
        TreeTraversal.inorderTraversal(deletionBT.root);
//        System.out.println("rightMost " + rightMost.key);
    }
}
