package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-18
 */
public class L714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];

            dp[1][0] = 0;
            dp[1][1] = -prices[0] - fee;

            for(int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
            }
            return Math.max(dp[n][0], dp[n][1]);
        }
    }
}
