package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-06
 */
public class L494 {
    class Solution {
        int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int n : nums) sum += n;
            // 这两种情况，不可能存在合法的子集划分
            if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
                return 0;
            }
            return subsets(nums, (sum + target) / 2);
        }

        // 计算 nums 中有几个子集的和为 sum
        public int subsets(int[] nums, int sum) {
            int n = nums.length;
            int[][] dp = new int[n + 1][sum + 1];
            // base case
            dp[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j >= nums[i-1]) {
                        // 两种选择的结果之和
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    } else {
                        // 背包的空间不足，只能选择不装物品 i
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][sum];
        }
    }
}
