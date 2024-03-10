package top.panson.injava.question.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-04 20:33
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
                char ch = s.charAt(right);
                right++;
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                while(window.get(ch) > 1) {
                    char remove = s.charAt(left);
                    left++;
                    window.put(remove, window.get(remove) - 1);
                }
                length = Math.max(length, right - left);
            }
            return length;
        }
    }
}
