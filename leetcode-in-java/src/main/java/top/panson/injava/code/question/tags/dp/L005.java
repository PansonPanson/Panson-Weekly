package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-21
 */
public class L005 {
    class Solution {
        public String longestPalindrome(String s) {
            // dp[i][j] : s 子串（i， j）是否是回文串
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int max = 1;
            int left = 0;
            int right = 0;
            for(int i = n - 1; i >= 0; i--) {
                for(int j = i + 1; j < n; j++) {
                    if(s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if(j - i <= 2) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    int len = j - i + 1;
                    if(dp[i][j] && len > max) {
                        left = i;
                        right = j;
                        max = len;
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }



}
