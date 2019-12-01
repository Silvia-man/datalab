package com.silvia.大二;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Silvia
 * @Date: 2019/11/17  17:19
 */

/*
编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
输入: 19
输出: true
解释:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
class Solution7 {   //使用快慢指针解决是否有循环的问题.
    // 若一个数是非快乐数，那么一直计算下去必定会出现循环，
    public int bitSquareSum(int n) {
        int sum = 0;
        while(n > 0)
        {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        }while(slow != fast);

        return slow == 1;
    }
}
public class 题202快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int m = 0;
        while(true){
            while(n != 0){
                m += Math.pow(n%10, 2);
                n /= 10;
            }
            if(m == 1){
                return true;
            }
            if(set.contains(m)){
                return false;
            }else{
                set.add(m);
                n = m;
                m = 0;
            }
        }
    }
}

