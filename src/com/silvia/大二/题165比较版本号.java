package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2019/12/8  16:59
 */

public class 题165比较版本号 {

    public int compareVersion1(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            String num1 = i < nums1.length ? nums1[i] : "0";
            String num2 = j < nums2.length ? nums2[j] : "0";
            int res = compare1(num1, num2);
            //int res = compare2(num1, num2);
            if (res == 0) {
                i++;
                j++;
            } else {
                return res;
            }
        }
        return 0;
    }

    private int compare2(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }

    private int compare1(String num1, String num2) {
        //将高位的 0 去掉
        num1 = removeFrontZero1(num1);
        num2 = removeFrontZero1(num2);
        //先根据长度进行判断
        if (num1.length() > num2.length()) {
            return 1;
        } else if (num1.length() < num2.length()) {
            return -1;
        } else {
            //长度相等的时候
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) - num2.charAt(i) > 0) {
                    return 1;
                } else if (num1.charAt(i) - num2.charAt(i) < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private String removeFrontZero1(String num) {
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        return num.substring(start);
    }
    // .匹配除换行符（\n、\r）之外的任何单个字符。要匹配包括 '\n' 在内的任何字符，请使用像"(.|\n)"的模式。
    // \.用来匹配点字符，而不是任何字符的通配符
    //按照「点」对版本号进行切割，然后依次比较每个数字即可。
    public int compareVersion(String version1, String version2) {

        // split表达式，其实就是一个正则表达式。*  ^ | 等符号在正则表达式中属于一种有特殊含义的字符，
        // 如果使用此种字符作为分隔符，必须使用转义符即\\加以转义
        String[] v1 = version1.split( "\\." );
        String[] v2 = version2.split( "\\." );

        int i;
        for (i = 0; i < v1.length && i < v2.length; i++ ) {
            //v1，v2相应位置的值比较，若值相同则继续往后比较。否则返回相应的1或-1。
            if (Integer.valueOf( v1[i] ) > Integer.valueOf( v2[i] )) {
                return 1;
            } else if (Integer.valueOf( v1[i] ) < Integer.valueOf( v2[i] )){
                return -1;
            }

        }

        //若比较至v1 或 v2的末尾还未比较出结果时，需要进一步判断：
        //1. v1，v2都走至末尾时，说明版本号相同。
        //2. v1，v2还有一方未完时，要么是v1，v2不同这种情况，要么是类似 "1.0" "1" 这种v1，v2相同的情况。
        if (i == v1.length && i == v2.length) {
            return 0;
        } else if (i == v2.length) {
            for (int j = i; j < v1.length; j++) {
                if (Integer.valueOf( v1[j] ) != 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int j = i; j < v2.length; j++) {
                if (Integer.valueOf( v2[j] ) != 0) {
                    return -1;
                }
            }
            return 0;
        }

    }
}
