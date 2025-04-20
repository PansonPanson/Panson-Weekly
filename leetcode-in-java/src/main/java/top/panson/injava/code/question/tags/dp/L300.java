package top.panson.injava.code.question.tags.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-04-20
 */
public class L300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
