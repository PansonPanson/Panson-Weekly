package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-22
 */
public class L005 {
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int start = 0;
            int end = 0;
            for(int i = 0; i < n; i++) {
                int length1 = expandAroundCenter(s, i, i);
                int length2 = expandAroundCenter(s, i, i + 1);
                int maxLength = Math.max(length1, length2);
                if(maxLength > end - start) {
                    start = i - (maxLength - 1) / 2;
                    end = i + maxLength / 2;
                }
            }
            return s.substring(start, end + 1);
        }


        public int expandAroundCenter(String s, int left, int right) {
            int n = s.length();
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
