package top.panson.injava.question.practice.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @create 2022-06-04 16:43
 * @Author: Panson
 */
public class L076 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            for(int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            Map<Character, Integer> window = new HashMap<>();
            // 左闭右开
            int left = 0;
            int right = 0;
            int valid = 0;
            while(right < s2.length()) {
                char ch = s2.charAt(right);
                right++;
                if(need.containsKey(ch)) {
                    int count = window.getOrDefault(ch, 0);
                    window.put(ch, count + 1);
                    if(count + 1 == need.get(ch)) {
                        valid++;
                    }
                }
                while(valid == need.size() && right - left >= s1.length()) {
                    if(right - left == s1.length()) {
                        return true;
                    }
                    // 收缩 left
                    char remove = s2.charAt(left);
                    left++;
                    if(need.containsKey(remove)) {
                        if(window.get(remove).equals(need.get(remove))) {
                            valid--;
                        }
                        window.put(remove, window.get(remove) - 1);
                    }
                }
            }
            return false;
        }
    }

}