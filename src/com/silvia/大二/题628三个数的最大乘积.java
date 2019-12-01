package com.silvia.大二;

import java.lang.reflect.Array;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class 题628三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        int[] max = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int min[] = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(int n : nums) {
            if (n < min[0]) {
                min[1] = min[0];
                min[0] = n;
            } else if (n < min[1]) {
                min[1] = n;
            }


            if (n > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = n;
            } else if (n > max[1]) {
                max[2] = max[1];
                max[1] = n;
            } else if (n > max[2]) {
                max[2] = n;
            }
        }

        return Math.max( max[0] * max[1] * max[2], min[0] * min[1] * max[0] );
    }
}
