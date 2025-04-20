package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-20
 */
public class L53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
