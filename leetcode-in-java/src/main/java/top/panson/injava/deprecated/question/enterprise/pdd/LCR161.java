package top.panson.injava.deprecated.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-13
 */
public class LCR161 {
    class Solution {
        public int maxSales(int[] sales) {
            // 动态规划：以某一天为结尾的连续子数组最大和
            // dp[i] = dp[i - 1] > 0 ? dp[i - 1] + sales[i] : sales[i];
            if(sales.length == 1) {
                return sales[0];
            }

            int[] dp = new int[sales.length + 1];
            dp[0] = sales[0];
            int max = dp[0];
            for(int i = 1; i < sales.length; i++) {
                dp[i] = dp[i - 1] > 0 ? dp[i - 1] + sales[i] : sales[i];
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }

    class Solution1 {
        public int maxSales(int[] sales) {
            // 动态规划：以某一天为结尾的连续子数组最大和
            // dp[i] = dp[i - 1] > 0 ? dp[i - 1] + sales[i] : sales[i];
            if(sales.length == 1) {
                return sales[0];
            }

            int pre = sales[0];
            int max = pre;
            for(int i = 1; i < sales.length; i++) {
                int cur = pre > 0 ? pre + sales[i] : sales[i];
                pre = cur;
                max = Math.max(cur, max);
            }
            return max;
        }
    }
}
