package top.panson.injava.code.question.tags.greedy;

/**
 * @author Panson
 * @create 2025-04-11
 */
// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组是数组中的一个连续部分。
public class L053 {
    // dp[i] : 以  nums[i] 为结尾的最大连续子数组和
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int pre = 0;
            int cur = 0;
            int res = nums[0];
            for(int i = 0; i < nums.length; i++) {
                cur = Math.max(pre + nums[i], nums[i]);
                res = Math.max(res, cur);
                pre = cur;
            }
            return res;
        }
    }
}
