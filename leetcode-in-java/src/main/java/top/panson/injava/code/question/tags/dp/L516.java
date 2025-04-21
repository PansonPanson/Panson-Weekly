package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-05
 */
public class L516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];

            // 初始化：单个字符是回文子序列
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            // 反向遍历 i，确保 i+1 在 i 的右侧
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            // 返回整个字符串的最长回文子序列长度
            return dp[0][n - 1];
        }
    }

    // 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

    class Solution1 {
        public int longestPalindromeSubseq(String s) {
            // dp[i] 以 s[i] 为中点
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            for(int i = n - 1; i >= 0; i--) {
                for(int j = i + 1; j < n; j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

}
