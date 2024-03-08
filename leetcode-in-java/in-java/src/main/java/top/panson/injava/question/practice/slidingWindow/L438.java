package top.panson.injava.question.practice.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-05-08 16:20
 * @Author: Panson
 */
public class L438 {

    static class Solution {

        public static void main(String[] args) {
            String s = "cbaebabacd";
            String p = "abc";
            List<Integer> anagrams = findAnagrams(s, p);
            System.out.println(anagrams);
        }
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            Map<Character, Integer> need = new HashMap<>();
            for(char ch : p.toCharArray()) {
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;

            Map<Character, Integer> window = new HashMap<>();
            while(right < s.length()) {
                char c = s.charAt(right);
                right++;
                if(need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                while(right - left >= p.length()) {
                    if(valid == need.size()) {
                        res.add(left);
                    }
                    char d = s.charAt(left);
                    left++;
                    if(need.containsKey(d)) {
                        if(need.get(d).equals(window.get(d))) {
                            valid--;
                        }
                        window.computeIfPresent(d, (k, v) -> v - 1);
                    }
                }
            }
            return res;
        }
    }
}
