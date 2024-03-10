package top.panson.injava.question.enterprise.bytedance.gjhds;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-05-02 00:20
 * @Author: Panson
 */
public class L003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int max = 0;

            for(int i = 0; i < s.length(); i++) {
                if(window.containsKey(s.charAt(i))) {
                    left = Math.max(left, window.get(s.charAt(i)) + 1);
                }
                max = Math.max(max, i - left + 1);
                window.put(s.charAt(i), i);
            }
            return max;
        }
    }
}
