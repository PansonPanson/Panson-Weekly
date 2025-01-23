package top.panson.injava.code.question.tags.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2024-08-21
 */
public class L567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for(char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;

            while(right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                // 进行窗口内数据更新
                if(need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(window.get(c).intValue() == need.get(c).intValue()) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
                while(right - left >= s1.length()) {
                    if(valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    left++;
                    if(need.containsKey(d)) {
                        if(need.get(d) == window.get(d)) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }
    }
}
