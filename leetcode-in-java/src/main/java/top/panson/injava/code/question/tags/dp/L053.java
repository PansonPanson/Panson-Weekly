package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2024-05-08
 */
public class L053 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }

            int ret = dp[0];

            for(int i = 1; i < dp.length; i++) {
                ret = Math.max(dp[i], ret);
            }
            return ret;
        }
    }
}
