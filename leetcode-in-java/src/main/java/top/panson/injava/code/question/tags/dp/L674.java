package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-20
 */
public class L674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = 1;
            int max = 1;
            for(int i = 1; i < n; i++) {
                if(nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                max = Math.max(max, dp[i]);
            }
            return max;

        }
    }

    class Solution1 {
        public int findLengthOfLCIS(int[] nums) {
            int n = nums.length;
            int dp0 = 1;
            int dp1 = 1;
            int max = 1;
            for(int i = 1; i < n; i++) {
                if(nums[i] > nums[i - 1]) {
                    dp1 = dp0 + 1;
                    dp0 = dp1;
                } else {
                    dp1 = 1;
                    dp0 = 1;
                }
                max = Math.max(max, dp1);
            }
            return max;

        }
    }
}
