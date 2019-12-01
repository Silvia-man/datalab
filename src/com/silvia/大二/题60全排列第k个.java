package com.silvia.大二;
import java.util.ArrayList;
import java.util.List;
public class 题60全排列第k个 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.getPermutation( 5, 62));
    }
}
/*
class Solution {
    public int fac(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i ++) {
            sum *= i;
        }
        return sum;
    }

    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i ++) {
            numList.add(i);
        }
        while (n > 1) {
            int index = (k - 1) / fac(n - 1);
            sb.append(numList.get(index));
            numList.remove(index);
            k -= index * fac(n - 1);
            n = numList.size();
        }
        sb.append(numList.get(0));

        return sb.toString();
    }
}

 */
class Solution4 {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre);
    }

    private int factorial(int n) {
        // 这种编码方式包括了 0 的阶乘是 1 这种情况
        int res = 1;
        while (n > 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            System.out.println(k + "  " + ps);
            if (k > ps) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            System.out.println(pre);

            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre);
        }
        // 如果参数正确的话，代码不会走到这里
        throw new RuntimeException("参数错误");
    }
}
