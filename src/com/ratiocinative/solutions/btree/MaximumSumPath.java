package com.ratiocinative.solutions.btree;

import com.ratiocinative.solutions.bst.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path does not need to go through the root.
 */
public class MaximumSumPath {

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSum(root, max);
        return max[0];
    }

    public int maxSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = maxSum(root.left, max);
        }
        int right = 0;
        if (root.right != null) {
            right = maxSum(root.right, max);
        }

        int all = left + right + root.val;
        int pathMax = Math.max(Math.max((root.val + left), (root.val + right)), root.val);
        int m = Math.max(all, pathMax);

        if (max[0] < m) {
            max[0] = m;
        }

        return pathMax;

    }
}
