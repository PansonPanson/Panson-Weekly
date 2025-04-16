package top.panson.injava.code.question.tags.binarysearch;

/**
 * @author Panson
 * @create 2025-04-15
 */
public class L033 {
    class Solution {
        public int search(int[] nums, int target) {
            // 二分，一半是有序的，如果在有序的这边，则直接二分查找，如果在无序的那边，无序部分继续二分
            int n = nums.length;
            return search(nums, target, 0,  n - 1);

        }

        public int search(int[] nums, int target, int left, int right) {
            // 二分，一半是有序的，如果在有序的这边，则直接二分查找，如果在无序的那边，无序部分继续二分
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] >= nums[left]) {
                    // 在左边有序
                    if(nums[mid] > target && target >= nums[left]) {
                        right = mid - 1;
                    } else  {
                        left = mid + 1;
                    }
                } else {
                    // 在右边有序
                    if(nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else  {
                        right = mid - 1;
                    }
                }
            }
            return -1;


        }
    }
}
