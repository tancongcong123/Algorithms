package com.example.algorithms.tree.valid;

import com.example.algorithms.tree.TreeNode;

public class Valid2 {

    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode node, int min, int max) {
        boolean letfresult = true;
        if(node.left != null){
            if((node.left.val >= node.val || node.left.val <= min)){
                return false;
            }
            letfresult = validate(node.left,node.val,min);
        }
        boolean rightresult = true;
        if(node.right != null){
            if(node.right.val >= max || node.right.val <= node.val){
                return false;
            }
            rightresult = validate(node.right,max,node.val);
        }
        return letfresult && rightresult;
    }
}
