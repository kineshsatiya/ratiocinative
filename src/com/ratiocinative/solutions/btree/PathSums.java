package com.ratiocinative.solutions.btree;

import com.ratiocinative.solutions.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSums {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        if (root == null) {
            return allPaths;
        }

        if (root.left == null && root.right == null) {
            String value = Integer.toString(root.val);
            allPaths.add(value);
            return allPaths;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for (String s : left) {
            allPaths.add(Integer.toString(root.val) + "->" + s);
        }

        for (String s : right) {
            allPaths.add(Integer.toString(root.val) + "->" + s);
        }

        return allPaths;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        int remaining = sum - root.val;
        if(remaining == 0 && root.left == null && root.right == null) {
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            res.add(li);
            return res;
        }

        List<List<Integer>> leftList = pathSum(root.left, remaining);
        List<List<Integer>> rightList = pathSum(root.right, remaining);

        for(List<Integer> l : leftList) {
            l.add(0,root.val);
        }

        for(List<Integer> r : rightList) {
            r.add(0, root.val);
        }

        res.addAll(leftList);
        res.addAll(rightList);

        return res;
    }
}
