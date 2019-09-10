package com.example.algorithms.tree.valid;

import com.example.algorithms.tree.TreeNode;

public class Valid1 {

    public boolean isValidBST(TreeNode root) {
        if (root==null || (root.left==null&&root.right==null))
            return true;
        boolean isValid;
        if (root.left==null){
            isValid = root.val<minRightVal(root.right);
        }else if (root.right==null){
            isValid = root.val>maxLeftVal(root.left);
        }else {
            isValid = root.val>maxLeftVal(root.left) && root.val<minRightVal(root.right);
        }
        return isValid&isValidBST(root.left)&&isValidBST(root.right);
    }

    private int maxLeftVal(TreeNode root) {
        if (root.right==null)
            return root.val;
        return Math.max(root.val, maxLeftVal(root.right));
    }

    private int minRightVal(TreeNode root) {
        if (root.left==null)
            return root.val;
        return Math.min(root.val, minRightVal(root.left));
    }
}
