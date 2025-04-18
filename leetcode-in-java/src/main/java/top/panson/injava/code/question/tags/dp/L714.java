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

    class Solution1 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0] - fee;

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;

            int dp0 = 0;
            int dp1 = -prices[0] - fee;

            for(int i = 1; i < n; i++) {
                int tmpDp0 = dp0;
                int tmpDp1 = dp1;
                dp0 = Math.max(tmpDp0, tmpDp1 + prices[i]);
                dp1 = Math.max(tmpDp1, tmpDp0 - prices[i] - fee);
            }
            return Math.max(dp0, dp1);
        }
    }
}
