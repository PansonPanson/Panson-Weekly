package top.panson.injava.question.codetop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-08 23:50
 * @Author: Panson
 */
public class L003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int length = 0;
            while(right < s.length()) {
                char cur = s.charAt(right);
                right++;
                if(window.containsKey(cur)) {
                    int preIndex = window.get(cur);
                    left = preIndex >= left ? preIndex + 1 : left;
                }
                window.put(cur, right - 1);
                length =  Math.max(length, right - left);
            }
            return length;
        }
    }
}
