package top.panson.injava.question.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-06-04 19:39
 * @Author: Panson
 */
public class L438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(int i = 0; i < p.length(); i++) {
                char ch = p.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            List<Integer> res = new ArrayList<>();

            while(right < s.length()) {
                char ch = s.charAt(right);
                right++;
                if(need.containsKey(ch)) {
                    int count = window.getOrDefault(ch, 0);
                    window.put(ch, count + 1);
                    if(count + 1 == need.get(ch)) {
                        valid++;
                    }
                }
                while(right -left >= p.length() && valid == need.size()) {
                    if(right - left == p.length()) {
                        res.add(left);
                    }
                    char remove = s.charAt(left);
                    left++;
                    if(need.containsKey(remove)) {
                        if(window.get(remove).equals(need.get(remove))) {
                            valid--;
                        }
                        window.put(remove, window.get(remove) - 1);
                    }
                }
            }
            return res;
        }
    }
}
