package top.panson.injava.question.practice.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-05-08 17:21
 * @Author: Panson
 */
public class L003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int res = 0;
            while(right < s.length()) {
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);

                while(window.getOrDefault(c, 0) > 1) {
                    char d = s.charAt(left);
                    left++;
                    window.put(d, window.get(d) - 1);
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
