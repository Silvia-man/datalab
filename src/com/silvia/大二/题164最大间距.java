package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2019/12/1  16:48
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * 示例 1
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 */
public class 题164最大间距 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort( nums );
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (diff < nums[i+1]-nums[i]) {
                diff = nums[i+1]-nums[i];
            }
        }
        return diff;
    }
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
            if (i != 0 && nums[i]-nums[i-1] > diff) {
                diff = nums[i]-nums[i-1];
            }
        }
        return diff;
    }
}
