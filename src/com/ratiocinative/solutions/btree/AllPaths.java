package com.ratiocinative.solutions.btree;

import com.ratiocinative.solutions.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

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
}
