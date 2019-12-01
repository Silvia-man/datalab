package com.silvia.大二;

import java.util.ArrayList;
import java.util.List;

public class 题119杨辉三角2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int k = 0; k <= rowIndex; k++) {
            ans.add(Combination(rowIndex, k));
        }
        return ans;
    }

    private int Combination(int rowIndex, int k) {
        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (rowIndex - k + i) / i;
        }

        return (int) res;
    }
}
/*
    升级版
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }



    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        }

        result.add(1);
        result.add(1);

        for (int i = 1; i < rowIndex; i++) {
            result.add(1);
            for (int j = 0; j < i; j++) {
                result.add(result.get(0) + result.get(1));
                result.remove(0);
            }
            result.add(1);
            result.remove(0);
        }

        return result;


    }



        List<Integer> res = new ArrayList<Integer>(rowIndex+1);
        long nk = 1;
        for(int i = 0; i <= rowIndex; i++){
                res.add((int)nk);
                nk = nk * (rowIndex - i) / (i + 1);
                }
                return res;


 */