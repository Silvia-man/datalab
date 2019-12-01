package com.silvia.大二;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

//定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，
// value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
// 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
// 此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
//

public class 题03无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //System.out.print("before    start: " + start + ",  map: " + map.get(alpha));
                start = Math.max(map.get(alpha), start);
                //System.out.println("    ,after start: " + start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}
