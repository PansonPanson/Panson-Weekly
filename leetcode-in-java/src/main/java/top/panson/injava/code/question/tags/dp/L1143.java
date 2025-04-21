package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-04
 */
public class L1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j]
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }


    class Solutio1n {
        public int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j] : text1 前 i 个字符子串 与 text2 前 j 个字符子串的最长公共子序列长度
            int n1 = text1.length();
            int n2 = text2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];
            for(int i = 1; i <= n1; i++) {
                for(int j = 1; j <= n2; j++) {
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n1][n2];
        }
    }


}
