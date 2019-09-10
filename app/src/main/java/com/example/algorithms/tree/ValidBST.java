package com.example.algorithms.tree;

import com.example.algorithms.tree.valid.Valid1;
import com.example.algorithms.tree.valid.Valid2;

/**
 * 判断其是否是一个有效的二叉搜索树
 *
 * 二叉搜索树具有如下特征:
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 */
public class ValidBST {

    public static void main(String[] args){
        TreeList treeList = new TreeList();

        Valid1 valid1 = new Valid1();
        System.out.println(valid1.isValidBST(treeList.initValidTree()));
        System.out.println(valid1.isValidBST(treeList.initValidTree2()));
        Valid2 valid2 = new Valid2();
        System.out.println(valid2.isValidBST(treeList.initValidTree()));
        System.out.println(valid2.isValidBST(treeList.initValidTree2()));
    }



}
