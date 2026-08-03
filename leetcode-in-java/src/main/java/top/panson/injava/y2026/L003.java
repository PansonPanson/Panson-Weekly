package top.panson.injava.y2026;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2026-08-04
 */
public class L003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int maxLen = 0;
            int left = -1;
            for(int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if(map.containsKey(cur)) {
                    left = Math.max(map.get(cur), left);
                }
                if(i - left > maxLen) {
                    maxLen = i - left;
                }
                map.put(cur, i);
            }
            return maxLen;
        }
    }
}
