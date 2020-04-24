package com.company;

public class NodeCountAtDist_K_fromLeaves {

    static int total_nodes = 0;

    static int findCountOfNodes(Node root, int k){
        if (root == null) return 0;
        int dist_l = findCountOfNodes(root.left,k);
        int dist_R = findCountOfNodes(root.right,k);
        if(dist_l == k || dist_R == k) {
            total_nodes++;
        }
        return Integer.min(dist_l,dist_R) + 1;
    }

    public static void main(String[] ar){
        Node root = TreeUtility.createTree();
        findCountOfNodes(root,0);
        System.out.println(total_nodes);
    }
}
