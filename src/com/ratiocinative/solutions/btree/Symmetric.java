package com.ratiocinative.solutions.btree;

import com.ratiocinative.solutions.bst.TreeNode;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymm(root.left, root.right);
    }

    public boolean isSymm(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSymm(left.left, right.right) && isSymm(left.right, right.left);
        }
        return false;

    }
}
