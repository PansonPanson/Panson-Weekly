package top.panson.injava.question.top100;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * @create 2022-01-17 14:29
 * @Author: Panson
 */
public class L053 {

    /**
     * 核心思路是采用动态规划： 如果此前累加最大和sum 大于0，那么说明是有效数据，如果 sum 小于等于 0， 那么是无效数据，直接废弃，使用下一个数
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
