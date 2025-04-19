package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-19
 */
public class L188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            // dp[i][j][0]: 第 i 天，最多完成 j 笔交易，当前没有持股
            // dp[i][j][1]: 第 i 天，最多完成 j 笔交易，当前持股
            int n = prices.length;
            int[][][] dp = new int[n][k + 1][2];
            for(int i = 0; i < n; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = 1;
            }
            for(int j = 0; j <= k; j++) {
                dp[0][j][0] = 0;
                dp[0][j][1] = -prices[0];
            }
            for(int i = 1; i < n; i++) {
                for(int j = 1; j <= k; j++) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }
            }
            return dp[n - 1][k][0];

        }
    }
}
