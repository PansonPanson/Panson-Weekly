package top.panson.injava.question.practice.dp;

/**
 * @create 2022-05-26 23:40
 * @Author: Panson
 */
public class L053 {

    class Solution {

        public int maxSubArray(int[] nums) {

            int max = nums[0];
            // 以当前遍历元素为结尾的子数组和的最大值
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                int tmp = sum;
                if(tmp < 0) {
                    // 重新计算子数组和
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
                max= Math.max(sum, max);
            }
            return max;
        }
    }
}
