package com.ratiocinative.solutions.bst;

public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }

    public TreeNode convertToBST(int[] nums, int low, int high) {
        if (low == high) {
            TreeNode n = new TreeNode(nums[low]);
            return n;
        }
        if (low < high) {
            int mid = ((high - low) / 2) + low;
            TreeNode n = new TreeNode(nums[mid]);
            n.left = convertToBST(nums, low, mid - 1);
            n.right = convertToBST(nums, mid + 1, high);
            return n;
        }
        return null;
    }
}
