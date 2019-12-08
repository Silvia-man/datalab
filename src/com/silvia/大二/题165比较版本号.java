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

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split( "\\." );
        String[] v2 = version2.split( "\\." );
        int i;
        for (i = 0; i < v1.length && i < v2.length; i++ ) {
            if (Integer.valueOf( v1[i] ) > Integer.valueOf( v2[i] )) {
                return 1;
            } else if (Integer.valueOf( v1[i] ) < Integer.valueOf( v2[i] )){
                return -1;
            }
        }
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
