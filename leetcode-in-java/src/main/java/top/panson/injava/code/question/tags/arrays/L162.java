package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-28
 */
public class L162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
