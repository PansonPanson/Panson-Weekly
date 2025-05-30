package top.panson.injava.code.question.codetop.bytedance;

/**
 * @create 2022-06-10 18:27
 * @Author: Panson
 */
public class L123 {

    class Solution {
        public int maxProfit(int[] prices) {
            int maxK = 2;
            int n = prices.length;
            int[][][] dp = new int[n][maxK + 1][2];
            for(int i = 0; i < n; i++) {
                for(int k = maxK; k >= 1; k--) {
                    if(i == 0) {
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[0];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][maxK][0];
        }
    }
}
