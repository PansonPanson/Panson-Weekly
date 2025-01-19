package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-19
 */
public class L392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() > t.length()) {
                return false;
            }
            if(s.equals(t)) {
                return true;
            }
            int i = 0;
            int j = 0;
            while(j < t.length()) {
                if(i < s.length() && s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == s.length();
        }
    }
}
