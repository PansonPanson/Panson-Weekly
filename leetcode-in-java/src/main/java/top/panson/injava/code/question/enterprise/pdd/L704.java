package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-02-13
 */
public class L704 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < target) {
                    left =  mid + 1;
                } else if(nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
