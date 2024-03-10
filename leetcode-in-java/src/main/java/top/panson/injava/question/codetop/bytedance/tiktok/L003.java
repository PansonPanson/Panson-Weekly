package top.panson.injava.question.codetop.bytedance.tiktok;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-06 16:35
 * @Author: Panson
 */
public class L003 {

    class Solution {

        public int lengthOfLongestSubstring(String s) {
            if(s== null || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int right = 0;
            int max = 1;
            // 112334
            for(int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                right++;
                if(!map.containsKey(cur)) {
                    map.put(cur, i);
                } else {
                    int preIndex = map.get(cur);
                    left = preIndex + 1;
                    map.put(cur, i);
                    max = Math.max(max, right - left);
                }
            }
            return max;
        }
    }
}
