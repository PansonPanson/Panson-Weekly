package top.panson.injava.code.question.enterprise.pdd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-01-19
 */
public class L409 {

    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int res = 0;
            System.out.println(map);
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                if(count % 2 == 0) {
                    res += count;
                } else {
                    if(count > 1) {
                        res += count - 1;
                    }
                }
            }
            return Math.min(s.length(), res + 1);
        }
    }
}
