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

    class Solution1 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if(sum % 2 != 0) {
                return false;
            }
            // dp[i][j] ： 表示前 i 个数中是否存在子集和为 j, return dp[nums.length + 1][sum / 2 + 1];
            // for(0 n-1) for(1 n -2)……for(n-2)
            boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
            for(int i = 0; i <= nums.length; i++) {
                for(int j = 0; j <= sum / 2; j++) {
                    if(i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if(i == 0) {
                        dp[i][j] = false;
                    } else if(j == 0) {
                        dp[i][j] = true;
                    } else {
                        if(j >= nums[i - 1]) {
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[nums.length][sum / 2];

        }
    }


    class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if(sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            boolean[] dp = new boolean[sum / 2 + 1];
            // dp[i] 表示容量为 i 的背包可不可以填满
            dp[0] = true;
            for(int num : nums) {
                for(int j = target; j >= num; j--) {
                    // 不选择 num || 选择 num
                    dp[j] = dp[j] || dp[j - num];
                }
            }
            return dp[target];

        }
    }
}
