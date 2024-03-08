package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-04-02 17:10
 * @Author: Panson
 */
public class L300 {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 1;
            for(int i = 0; i < dp.length; i++) {
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
