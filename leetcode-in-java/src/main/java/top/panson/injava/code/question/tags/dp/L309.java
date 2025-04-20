package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-20
 */
public class L309 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][3];
            // dp[i][0]: 未持股，今天未卖出  dp[i][1] : 持股  dp[i][2] : 未持股，今天卖出
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = dp[i - 1][1];
            }
            return Math.max(dp[n - 1][0], dp[n - 1][2]);
        }
    }
}
