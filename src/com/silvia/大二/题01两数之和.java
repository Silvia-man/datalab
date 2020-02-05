package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2020/2/5  19:44
 */
public class 题01两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] n = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    n[0] = i;
                    n[1] = j;
                    return  n;
                }
            }
        }
        return n;
    }
}
