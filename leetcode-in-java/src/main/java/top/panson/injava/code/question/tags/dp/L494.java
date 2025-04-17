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

    class Solution1 {
        public int findTargetSumWays(int[] nums, int target) {
            // dp[i][j] : 选择前 i 个 数，是否可以构造和为 j
            // dp[i][j] = dp[i - 1][j - num[i - 1]] || dp[i - 1][j + nums[i - 1]]
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if((sum + target) % 2 != 0 || Math.abs(target) > sum) {
                return 0;
            }
            target = (sum + target) / 2;
            int n = nums.length;
            // dp[j]: 选出和为 j 的子集个数
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int num : nums) {
                for(int j = target; j >= num; j--) {
                    // 选择 num || 不选择
                    dp[j] += dp[j - num];
                }
            }
            return dp[target];
        }
    }


    class Solution2 {
        public int findTargetSumWays(int[] nums, int target) {
            // dp[i][j] : 选择前 i 个 数，是否可以构造和为 j
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if((sum + target) % 2 != 0 || Math.abs(target) > sum) {
                return 0;
            }
            target = (sum + target) / 2;
            int n = nums.length;
            // dp[i][j] : 选择 i 个元素和为j 的子集个数
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;

            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= target; j++) {
                    if(j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][target];
        }
    }
}
