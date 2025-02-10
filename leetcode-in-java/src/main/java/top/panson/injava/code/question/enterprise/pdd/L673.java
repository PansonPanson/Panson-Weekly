package top.panson.injava.code.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-02-10
 */
public class L673 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;

            int[] dp = new int[n];     // dp[i]: 以 nums[i] 结尾的最长递增子序列长度
            int[] count = new int[n];  // count[i]: 以 nums[i] 结尾的最长递增子序列个数
            Arrays.fill(dp, 1);        // 初始情况下，每个数都可以独立成为子序列，长度为 1
            Arrays.fill(count, 1);     // 初始时，每个数的方案数为 1

            int maxLen = 1;  // 记录最长递增子序列的长度
            int result = 0;  // 记录最长递增子序列的个数

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {  // 只有递增时才更新
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;  // 更新最长长度
                            count[i] = count[j];  // 继承方案数
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j];  // 累加方案数
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);  // 记录最长递增子序列的长度
            }

            // 统计所有 dp[i] == maxLen 的 count[i] 之和
            for (int i = 0; i < n; i++) {
                if (dp[i] == maxLen) {
                    result += count[i];
                }
            }

            return result;
        }
    }

}
