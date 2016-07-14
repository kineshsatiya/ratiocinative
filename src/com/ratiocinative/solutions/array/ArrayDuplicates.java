package com.ratiocinative.solutions.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicates {

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the
     * array such that nums[i] = nums[j] and the difference between i and j is at most k.
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                System.out.println(nums[i]);
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
