package com.silvia.大二;

import java.util.ArrayList;

public class 题673最长递增子序列的个数 {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] L = {1, 3, 5, 4, 7 };
        System.out.println(s1.findNumberOfLIS( L ));
    }


}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] L = new int[n];
        int[] count = new int[n];
        int longest = 0;
        int result = 0;

        for (int j = 0; j < n; j++) {
            L[j] = 1;
            count[j] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (L[i] < L[j] + 1) {
                        L[i] = L[j] + 1;
                        count[i] = count[j];
                    }
                    else if (L[i] == L[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (longest < L[i]) {
                longest = L[i];
            }
        }

        if (longest == 1) {
            return nums.length;
        }
        for (int i = 0; i < n; i++) {
            if (L[i] == longest) {
                result += count[i];
            }
        }

        return result;
    }

};