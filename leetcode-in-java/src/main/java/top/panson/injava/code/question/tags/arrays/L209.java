package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(i == 0) {
                        dp[i][j] = dp[i][j - 1] + nums[j];
                    } else {
                        dp[i][j] = dp[0][j] - dp[0][i - 1];
                    }
                }
            }
            int min = n + 1;
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(dp[i][j] >= target) {
                        min = Math.min(j - i + 1, min);
                    }
                }
            }
            return min == n + 1 ? 0 : min;
        }
    }
}
