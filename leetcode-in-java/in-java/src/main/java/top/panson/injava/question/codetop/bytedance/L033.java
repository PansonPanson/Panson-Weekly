package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-12 00:27
 * @Author: Panson
 */
public class L033 {

    class Solution {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0) {
                return -1;
            }
            if(nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0;
            int r = nums.length -1;

            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(nums[mid] == target) {
                    return mid;
                }

                // 左半边有序 小于等于是因为 两个数 【3,1】
                if(nums[0] <=  nums[mid]) {
                    if(nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    // 右半边有序
                    if(nums[mid] < target && target <= nums[nums.length - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
