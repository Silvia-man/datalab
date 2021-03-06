package com.silvia.大二;

import java.util.Arrays;

/**
 * @Author: Silvia
 * @Date: 2019/12/15  16:23
 */
public class 题213打家劫舍2 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob( Arrays.copyOfRange(nums, 1, nums.length)));
    }
    int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}