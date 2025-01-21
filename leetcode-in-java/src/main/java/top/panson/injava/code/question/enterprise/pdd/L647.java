package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-22
 */
public class L647 {


    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            int count = 0;
            for(int i = 0; i < n; i++) {
                count += expandAroundCenter(s, i, i);
                count += expandAroundCenter(s, i, i + 1);
            }
            return count;
        }

        public int expandAroundCenter(String s, int left, int right) {
            int count = 0;
            int n = s.length();
            while(left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            return count;
        }
    }
}
