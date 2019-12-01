package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2019/11/11  14:06
 */
public class 题8字符串转换整数 {
    public  int myAtoi(String str) {
        String temp = str.trim();
        //trim()方法会去掉字符串两端的空格。
        //trim()方法实际上trim掉了字符串两端Unicode编码小于等于32（\u0020）的所有字符。
        boolean flag = true;
        char[] bits = temp.toCharArray();
        int i = 0;
        int res = 0;
        int bit = 0;

        if (str == null) {
            return 0;
        }
        if (temp == "" || temp.length() == 0) {
            return 0;
        }
        if (bits[0] == '-') {
            flag = false;
        }
        if (bits[0] == '+' || bits[0] == '-') {
            i++;
        }
        for (; i < bits.length; i++) {
            if (bits[i] >= '0' && bits[i] <= '9') {
                bit = bits[i] - '0';
            } else {
                break;
            }

            //int最大数个位是7
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && bit > 7)) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + bit;
        }
        return flag ? res : -res;
    }
}