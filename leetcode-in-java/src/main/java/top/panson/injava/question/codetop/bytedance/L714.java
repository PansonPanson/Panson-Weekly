package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-10 16:48
 * @Author: Panson
 */
public class L714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for(int i = 0; i < n; i++) {
                if(i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0] - fee;
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return dp[n - 1][0];
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int dpi0 = 0;
            int dpi1 = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int tmp = dpi0;
                dpi0 = Math.max(dpi0, dpi1 + prices[i]);
                dpi1 = Math.max(dpi1, tmp - prices[i] - fee);
            }
            return dpi0;
        }
    }
}
