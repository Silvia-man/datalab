package com.silvia.大二;

import java.util.HashSet;

public class 题217存在重复元素 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution1 test = new Solution1();
        test.containsDuplicate( nums );
    }
}

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        int length=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
