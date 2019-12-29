package com.silvia.大二;

import java.util.ArrayList;

/**
 * @Author: Silvia
 * @Date: 2019/12/29  18:34
 */
/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 */
public class 题500键盘行 {
    public String[] findWords(String[] words) {
        String line[] = {"QWERTYUIOPqwertyuiop","ASDFGHJKLasdfghjkl","ZXCVBNMzxcvbnm"};

        ArrayList<String> rr = new ArrayList<>(  );

        for (String word : words) {
            int t = 0;
            int flag = 1;
            if (line[0].contains( word.charAt( 0 ) + "" )) {
                t = 0;
            } else if (line[1].contains( word.charAt( 0 ) + "" )){
                t = 1;
            } else {
                t = 2;
            }
            for (int i = 1; i < word.length(); i++) {
                if (line[t].contains( word.charAt( i ) + "" ) == false) {
                   // System.out.println(word + "  i :" + i + " " + word.charAt( i ) );
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                rr.add( word );
            }
        }
        String[] re = new String[rr.size()];
        for (int i = 0; i < rr.size(); i++) {
            re[i] = rr.get( i );
        }

        return re;
    }
}
