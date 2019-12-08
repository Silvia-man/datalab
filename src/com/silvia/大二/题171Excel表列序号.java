package com.silvia.大二;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;

/**
 * @Author: Silvia
 * @Date: 2019/12/8  19:29
 */
/*
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
 */
public class 题171Excel表列序号 {

    public int titleToNumber(String s) {
        int sum = 0;
        int m = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt( i );
            sum += (c-'A'+1) * m;//Math.pow( 26, s.length() - 1 - i );
            m *= 26;
        }
        return sum;
    }
}
