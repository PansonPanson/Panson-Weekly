package top.panson.injava.tags.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-08-21
 */
public class L438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(char c : p.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            List<Integer> res = new ArrayList<>();
            while(right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据更新
                if(need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(window.get(c).intValue() == need.get(c).intValue()) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
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
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return res;
        }
    }
}
