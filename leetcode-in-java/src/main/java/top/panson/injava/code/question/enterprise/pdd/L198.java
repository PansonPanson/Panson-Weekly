package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L198 {
    class Solution {
        public int rob(int[] nums) {
            // dp[i] = Math.max(dp[i -2] + nums[i - 1], dp[i - 1]);
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for(int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            return dp[n];
        }
    }
}
