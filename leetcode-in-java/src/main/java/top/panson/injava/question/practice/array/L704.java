package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-04 22:39
 * @Author: Panson
 */
public class L704 {

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left <= right) {
                int mid = (right - left) / 2 + left;
                if(target == nums[mid]) {
                    return mid;
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else if(nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
