package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-05
 */
public class L1312 {
    public class Solution {
        public int minInsertions(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];

            // 从后往前遍历 i，确保 dp[i+1][j] 已经计算
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];  // 若相等，不需要额外插入
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1; // 插入字符
                    }
                }
            }

            return dp[0][n - 1];  // s[0:n] 变成回文的最少插入次数
        }
    }

}
