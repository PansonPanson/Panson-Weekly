package top.panson.injava.code.question.tags.binarysearch;

/**
 * @author Panson
 * @create 2025-04-16
 */
public class L153 {

    class Solution {
        public int findMin(int[] nums) {
            int index = findMin(nums, 0, nums.length - 1);
            return nums[index];
        }

        public int findMin(int[] nums, int left, int right) {
            // if(nums[right] > nums[left]) {
            //     return left;
            // }
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] > nums[right]) {
                    // 最小值在右半边（排除 mid）
                    left = mid + 1;
                } else {
                    // 数组的中间值小于或等于右边的值，说明最小值在左边，最小值在左半边（包含 mid）
                    right = mid;
                }
            }
            return left;
        }
    }
}
