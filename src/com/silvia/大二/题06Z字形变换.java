package com.silvia.大二;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Silvia
 * @Date: 2020/1/21  22:07
 */
public class 题06Z字形变换 {

    class Solution {
        public String convert(String s, int numRows) {
            if(numRows < 2)
                return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for(int i = 0; i < numRows; i++)
                rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag; //重要！
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows)
                res.append(row);
            return res.toString();
        }
    }

}
    /*
    public String convert(String s, int numRows) {
        for(int i = 0; i < numRows; i++) {
            for (int x = 0; x < s.length(); i++) {

            }
            System.out.print(s.charAt( i ));
            for(int j = 0; j < )



        }
    }
*/