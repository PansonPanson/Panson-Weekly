package top.panson.injava.year2526interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-11-03
 */
public class LeetCode003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> lastPos = new HashMap<>();
            int maxLen = 0;
            int left = 0;  // 滑动窗口的左边界

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);

                // 如果该字符在之前出现过，并且位置 >= 当前窗口左边界
                if (lastPos.containsKey(c) && lastPos.get(c) >= left) {
                    // 窗口左边界跳到重复字符的下一位
                    left = lastPos.get(c) + 1;
                }

                // 更新字符 c 最新出现的位置
                lastPos.put(c, right);

                // 更新最长子串长度
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    }
}
