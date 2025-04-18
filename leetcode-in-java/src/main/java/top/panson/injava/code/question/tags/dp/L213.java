package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-18
 */
public class L213 {

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0]; // 只有一个房子特殊处理
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }

        public int rob(int[] nums, int start, int end) {
            int n = end - start + 1;
            int[][] dp = new int[nums.length + 1][2];
            dp[start][0] = 0;
            dp[start][1] = nums[start];
            for(int i = start + 1; i <= end; i++) {
                // 不偷
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                // 偷
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[end][0], dp[end][1]);
        }
    }
}
