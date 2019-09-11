package com.example.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 *
 * 运用递归和迭代两种方法
 *
 * input:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * output: true
 * input:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * output: false
 */
public class SymmetricTree {

    public static void main(String[] args){
        TreeList treeList = new TreeList();
        System.out.println(isSymmetric(treeList.initSymmetricTree()));
        System.out.println(isSymmetric(treeList.initSymmetricTree2()));

        System.out.println("--------------");

        System.out.println(isSymmetric2(treeList.initSymmetricTree()));
        System.out.println(isSymmetric2(treeList.initSymmetricTree2()));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root==null || (root.left==null&&root.right==null))
            return true;
        List<TreeNode> preTreeNodes = new ArrayList<>();
        List<TreeNode> curTreeNodes = new ArrayList<>();
        preTreeNodes.add(root);
        while (true){
            curTreeNodes.clear();
            boolean isAllNull = true;
            for (int i=0;i<preTreeNodes.size();i++){
                if (preTreeNodes.get(i)!=null){
                    curTreeNodes.add(preTreeNodes.get(i).left);
                    curTreeNodes.add(preTreeNodes.get(i).right);
                    if (preTreeNodes.get(i).left!=null||preTreeNodes.get(i).right!=null){
                        isAllNull = false;
                    }
                }
            }
            if (isAllNull)
                return true;
            int pre = 0;
            int last = curTreeNodes.size()-1;
            while (pre<last){
                if (curTreeNodes.get(pre)!=null && curTreeNodes.get(last)!=null){
                    if (curTreeNodes.get(pre).val!=curTreeNodes.get(last).val){
                        return false;
                    }
                }else if(curTreeNodes.get(pre)!=null && curTreeNodes.get(last)==null){
                    return false;
                }else if(curTreeNodes.get(pre)==null && curTreeNodes.get(last)!=null){
                    return false;
                }
                pre++;
                last--;
            }
            preTreeNodes.clear();
            preTreeNodes.addAll(curTreeNodes);
        }
    }

    public static boolean isSymmetric2(TreeNode root) {
        return symmetric(root, root);
    }

    public static boolean symmetric(TreeNode pre, TreeNode last) {
        if(pre == null && last == null)
            return true;
        if(pre!=null && last!=null && pre.val==last.val  )
            return symmetric(pre.left,last.right) && symmetric(pre.right,last.left);
        else
            return false;
    }
}
