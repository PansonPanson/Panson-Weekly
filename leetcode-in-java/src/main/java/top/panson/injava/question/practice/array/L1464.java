package top.panson.injava.question.practice.array;

import java.util.Arrays;

/**
 * @create 2022-08-26 10:09
 * @Author: Panson
 */
public class L1464 {

    class Solution {
        public int maxProduct(int[] nums) {
            int left = 0, right = nums.length - 1, max = Integer.MIN_VALUE;
            while(left < right) {
                max = Math.max(max, (nums[right] - 1) * (nums[left] - 1));
                if(nums[left] < nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }

    class Solution1 {
        public int maxProduct(int[] nums) {
            int max0 = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE;

            for(int num : nums) {
                if(num >= max0) {
                    max1 = max0;
                    max0 = num;
                } else if(num >= max1){
                    max1 = num;
                }
            }
            return (max0 - 1) * (max1 - 1);
        }
    }
}
