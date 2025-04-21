package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-04
 */
public class L583 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int lcs = longestCommonSubsequence(word1, word2);
            return m - lcs + n - lcs;
        }

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


    class Solution1{
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示 word1[0..i-1] 和 word2[0..j-1] 的 LCS 长度

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // 匹配，LCS + 1
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 不匹配，取左或上较大者
                    }
                }
            }

            int lcs = dp[m][n];
            return m + n - 2 * lcs;
        }
    }
}
