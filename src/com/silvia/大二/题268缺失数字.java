package com.silvia.大二;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class 题268缺失数字 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        System.out.println(missingNumber( nums ));
    }

    /**
     * 这个题有一个很直观的解法：求出0-n的和，然后求出数组所有数的和，两个和相减，得到结果。
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int elem : nums) {
            sum += elem;
        }
        return ((1 + nums.length) * nums.length / 2) - sum;
    }
}
