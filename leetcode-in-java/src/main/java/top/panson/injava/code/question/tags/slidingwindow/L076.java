package top.panson.injava.code.question.tags.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-08-21
 */
public class L076 {
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            int start = 0;
            int length = Integer.MAX_VALUE;
            while(right < s.length()) {
                char c = s.charAt(right);
                right++;
                if(need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                while(valid == need.size()) {
                    if(right - left < length) {
                        start = left;
                        length = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if(need.containsKey(d)) {
                        if(window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);

        }
    }
}
