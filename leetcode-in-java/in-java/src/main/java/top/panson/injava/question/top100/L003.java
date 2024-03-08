package top.panson.injava.question.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * @create 2022-01-12 16:10
 * @Author: Panson
 */
public class L003 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring(" "));
            System.out.println(lengthOfLongestSubstring("abx"));
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
            System.out.println(lengthOfLongestSubstring("pwwkew"));
        }

        /**
         * 核心思路是利用双指针 + 哈希表
         * 没有重复元素时，head 指针不动
         * 当有重复元素时，若在此之前最后一次出现的重复元素的下标大于head 指针，head 指针移动，覆盖最后一次出现的重复元素的下标
         * @param s
         * @return
         */
        public static int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int head = -1;
            for (int i = 0; i < s.length(); i++) {
                Character character = s.charAt(i);
                Integer index = map.get(character);
                if (index != null && index > head) {
                        head = index;
                }
                max = Math.max(max, i - head);
                map.put(character, i);
            }
            return max;
        }
    }

    // 0507
    static class Solution001 {


        public static void main(String[] args) {
            String s = "pwwkew";
            int i = lengthOfLongestSubstring(s);
            System.out.println(i);
        }
        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int count = 0;
            int head = -1;
            for(int i = 0; i < s.length(); i++) {
                Character current = s.charAt(i);
                Integer index = map.get(current);
                if(index != null && index > head) {
                    head = index;
                }
                count = Math.max(i - head, count);
                map.put(current, i);
            }
            return count;
        }
    }

    class Solution002 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int res = 0;
            while(right < s.length()) {
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);

                while(window.getOrDefault(c, 0) > 1) {
                    char d = s.charAt(left);
                    left++;
                    window.put(d, window.get(d) - 1);
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }





}
