package com.silvia.大二;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Silvia
 * @Date: 2020/2/5  19:44
 */
public class 题01两数之和 {

    public int[] twoSum2(int[] nums, int target) {    //用哈希表实现查找！
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

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


