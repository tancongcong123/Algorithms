package com.example.algorithms.tree;

public class TreeList {

    /**
     *   3
     *  /  \
     * 9   20
     *     / \
     *   15  7
     *   /
     *  12
     *
     * @return
     */
    public TreeNode initMaxDepthTree(){
        TreeNode header = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        header.left = left;
        header.right = right;
        left = new TreeNode(15);
        right = new TreeNode(7);
        header.right.left = left;
        header.right.right = right;
        left = new TreeNode(12);
        header.right.left.left = left;
        return header;
    }

    /**
     *    2
     *  /  \
     * 1    5
     *
     * @return
     */
    public TreeNode initValidTree(){
        TreeNode header = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        header.left = left;
        header.right = right;
        return header;
    }

    /**
     *    4
     *  /  \
     * 1    5
     *     / \
     *    3  6
     * @return
     */
    public TreeNode initValidTree2(){
        TreeNode header = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        header.left = left;
        header.right = right;
        left = new TreeNode(3);
        right = new TreeNode(6);
        header.right.left = left;
        header.right.right = right;
        return header;
    }
}
