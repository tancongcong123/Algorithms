package com.example.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 */
public class LevelOrder {

    public static void main(String[] args){
        TreeList treeList = new TreeList();
        System.out.println("----------------------------");
        levelOrder(treeList.initSymmetricTree());
        System.out.println("end----------------------------");
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> preTreeNodes = new ArrayList<>();
        List<TreeNode> curTreeNodes = new ArrayList<>();
        preTreeNodes.add(root);
        while (true){
            curTreeNodes.clear();
            List<Integer> levelNode = new ArrayList<>();
            for (int i=0;i<preTreeNodes.size();i++){
                levelNode.add(preTreeNodes.get(i).val);
                if (preTreeNodes.get(i).left!=null){
                    curTreeNodes.add(preTreeNodes.get(i).left);
                }
                if (preTreeNodes.get(i).right!=null){
                    curTreeNodes.add(preTreeNodes.get(i).right);
                }
            }
            result.add(levelNode);
            if (curTreeNodes.size()>0){
                preTreeNodes.clear();
                preTreeNodes.addAll(curTreeNodes);
            }else {
                return result;
            }
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        DFS(root, 0);
        return res;
    }

    private void DFS(TreeNode root, int level) {
        //递归终止条件
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            //如果是新的一层,就创建
            res.add(new ArrayList<Integer>());
        }
        //添加当前的元素
        res.get(level).add(root.val);
        //遍历左节点
        DFS(root.left, level + 1);
        //遍历又节点
        DFS(root.right, level + 1);

    }
}
