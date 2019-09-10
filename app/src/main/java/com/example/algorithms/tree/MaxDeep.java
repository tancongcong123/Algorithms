package com.example.algorithms.tree;

/**
 * 二叉树的最大深度
 */
public class MaxDeep {

    public static void main(String[] args){
        TreeList treeList = new TreeList();
        TreeNode header = treeList.initMaxDepthTree();
        System.out.println(maxDepth(header));
    }

    public static int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
