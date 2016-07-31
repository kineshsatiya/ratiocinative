package com.ratiocinative.solutions.array;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;
        while (k < n && nums[k] == k) k++;
        if (n == 0 || k < n) return k;
        else return nums[0] == k ? k + 1 : k;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
