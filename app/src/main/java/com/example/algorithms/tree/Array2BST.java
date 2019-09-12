package com.example.algorithms.tree;

import java.util.Arrays;

/**
 * 有序数组转换为二叉搜索树
 * 一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 */
public class Array2BST {

    private static int[] numbers = {-10,-3,0,5,9,11};
//    private static int[] numbers = {1,2,3,4};

    public static void main(String[] args){
        TreeNode top = sortedArrayToBST(numbers);
        System.out.println(top==null?"NULL":top.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length<1)
            return null;
        if (nums.length==1)
            return new TreeNode(nums[0]);
        int headerIndex = nums.length/2;
        TreeNode header = new TreeNode(nums[headerIndex]);
        header.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,headerIndex));
        header.right = sortedArrayToBST(Arrays.copyOfRange(nums,headerIndex+1,nums.length));
        return header;
    }

    public static TreeNode sortedArrayToBST2(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }

    public static TreeNode sortedArrayToBST(int[] nums,int l,int r){
        if(l==r)
            return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,l,mid);
        root.right=sortedArrayToBST(nums,mid+1,r);
        return root;
    }
}
