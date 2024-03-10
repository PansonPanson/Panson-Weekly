package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-10 19:04
 * @Author: Panson
 */
public class L188 {

    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (n <= 0) {
                return 0;
            }
            if(k > prices.length / 2) {
                return maxProfit(prices);
            }
            int[][][] dp = new int[n][k + 1][2];
            for(int i = 0; i < n; i++) {
                for(int j = k; j >= 1; j--) {
                    if(i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for(int i = 0; i < n; i++) {
                if(i == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }


    }
}
