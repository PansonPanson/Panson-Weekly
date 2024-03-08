package top.panson.injava.question.top100;

import java.util.Arrays;

/**
 * @create 2022-01-20 16:41
 * @Author: Panson
 */
public class L283 {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = new int[]{0,1,0,3,12};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }


        public static void moveZeroes(int[] nums) {
            int nonzeroCount = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    swap(nums, nonzeroCount, i);
                    nonzeroCount++;
                }
            }
        }

        private static void swap(int[] nums, int zeroIndex, int i) {
            int temp = nums[zeroIndex];
            nums[zeroIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
