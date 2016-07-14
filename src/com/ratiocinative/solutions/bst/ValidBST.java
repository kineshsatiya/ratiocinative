package com.ratiocinative.solutions.bst;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }

    public boolean isBST(TreeNode root, int min, int max, boolean seenMax, boolean seenMin) {
        if (root == null) {
            return true;
        }

        if (root.val >= max) {
            if (root.val == Integer.MAX_VALUE && max == Integer.MAX_VALUE && !seenMax) {
                seenMax = true;
            } else {
                return false;
            }
        }

        if (root.val <= min) {
            if (root.val == Integer.MIN_VALUE && min == Integer.MIN_VALUE && !seenMin) {
                seenMin = true;
            } else {
                return false;
            }
        }

        return isBST(root.left, min, root.val, seenMax, seenMin) && isBST(root.right, root.val, max, seenMax, seenMin);
    }
}
