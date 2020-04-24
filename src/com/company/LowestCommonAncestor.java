package com.company;

public class LowestCommonAncestor {


    static Node findLCA(Node n1, Node n2, Node root){
        if (root == null) return root;
        if(root.key == n1.key || root.key == n2.key) return root;
        Node left = findLCA(n1,n2,root.left);
        Node right = findLCA(n1,n2,root.right);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args){
        Node root = TreeUtility.createTree();
        Node n1 = new Node(4);
        Node n2 = new Node(7);
        Node output = findLCA(n1,n2,root);
        System.out.println(output.key);

        int distance = TreeUtility.findDistanceBetweenTwoNodes(root,n1,n2);
        System.out.println(distance);
    }
}
