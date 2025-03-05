package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-05
 */
public class L416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0) return false;
            int n = nums.length;
            sum = sum / 2;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            // base case
            for (int i = 0; i <= n; i++)
                dp[i][0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j - nums[i - 1] < 0) {
                        // 背包容量不足，不能装入第 i 个物品
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 装入或不装入背包
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[n][sum];
        }
    }
}
