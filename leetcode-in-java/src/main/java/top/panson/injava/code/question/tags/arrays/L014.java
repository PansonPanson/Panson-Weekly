package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L014 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0) {
                return "";
            }
            String first = strs[0];
            if(first == null || first.length() == 0) {
                return "";
            }

            for(int i = 0; i < first.length(); i++) {
                char c = first.charAt(i);
                for(int j = 1; j < strs.length; j++) {
                    String str = strs[j];
                    if(i >= str.length() || str.charAt(i) != c) {
                        return first.substring(0, i);
                    }
                }
            }
            return first;
        }
    }
}
