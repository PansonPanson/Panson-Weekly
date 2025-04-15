package top.panson.injava.code.question.tags.binarysearch;

/**
 * @author Panson
 * @create 2025-04-15
 */
public class L034 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target, 0, nums.length - 1);
            int right = searchRight(nums, target, 0, nums.length - 1);
            return new int[]{left, right};
        }

        public int searchLeft(int[] nums, int target, int left, int right) {
            int res = -1;
            while(left <= right) {
                int mid = (right - left) / 2  + left;

                if(nums[mid] == target) {
                    res = mid;
                    right = mid - 1;
                } else if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        public int searchRight(int[] nums, int target, int left, int right) {
            int res = -1;
            while(left <= right) {
                int mid = (right - left) / 2  + left;

                if(nums[mid] == target) {
                    res = mid;
                    left = mid + 1;
                } else if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }
}
