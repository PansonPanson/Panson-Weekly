package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L628 {

    class Solution {
        public int maximumProduct(int[] nums) {
            // 如果3个数都是正数，那么取最大的三个数
            // 如果2正（或者0）1负，那么取两个正数和最大的一个负数，其实就是取最大的三个数
            // 如果1正2负，那么取最小的2个负数和最大的一个正数
            // 如果是3个负数，那么取最大的3个数
            Arrays.sort(nums);
            if(nums.length == 3) {
                return nums[0] * nums[1] * nums[2];
            }
            //    int a = nums[0];
            //    int b = nums[1];
            //    int c = nums[nums.length - 3];
            //    int d = nums[nums.length - 2];
            //    int e = nums[nums.length - 1];

            return Math.max(nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1], nums[0] * nums[1] * nums[nums.length - 1]);
        }
    }
}
