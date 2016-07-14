package com.ratiocinative.solutions.bst;

public class BalancedTree {

    boolean balanced;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            this.balanced = true;
            checkBalance(root);
            return balanced;
        }
    }

    public int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int l = checkBalance(root.left);
            int r = checkBalance(root.right);
            if (Math.abs(l - r) > 1) {
                balanced = false;
            }
            return l > r ? (l + 1) : (r + 1);
        }
    }
}
