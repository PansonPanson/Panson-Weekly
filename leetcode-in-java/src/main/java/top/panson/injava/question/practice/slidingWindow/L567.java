package top.panson.injava.question.practice.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-05-08 15:36
 * @Author: Panson
 */
public class L567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            for(char ch : s1.toCharArray()) {
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int valid = 0;

            while(right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if(need.containsKey(c)) {
                   window.put(c, window.getOrDefault(c, 0) + 1);
                   if(need.get(c).equals(window.get(c))) {
                       valid++;
                   }
                }

                while(right - left >= s1.length()) {
                    if(valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    left++;
                    if(need.containsKey(d)) {
                        if(need.get(d).equals(window.get(d))) {
                            valid--;
                        }
                        window.computeIfPresent(d, (k, v) -> v - 1);
                    }
                }
            }
            return false;
        }
    }
}
