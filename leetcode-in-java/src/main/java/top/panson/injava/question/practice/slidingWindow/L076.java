package top.panson.injava.question.practice.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-05-08 12:20
 * @Author: Panson
 */
public class L076 {
    static class Solution {

        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            System.out.println(minWindow(s, t));
        }
        public static String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int valid = 0;
            int length = Integer.MAX_VALUE;
            int start = 0;
            for(int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

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
            return length == Integer.MAX_VALUE ? "": s.substring(start, start + length);
        }
    }
}
