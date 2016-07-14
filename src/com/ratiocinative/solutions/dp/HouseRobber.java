package com.ratiocinative.solutions.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length < 1)
            return 0;

        int p1 = nums[0], p2 = 0;
        int curr = p1;
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(p1, p2 + nums[i]);
            p2 = p1;
            p1 = curr;

        }
        return curr;
    }
}
