package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-20
 */
public class L34 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0) {
                return new int[]{-1, -1};
            }
            if(nums.length == 1 && nums[0] == target) {
                return new int[]{0, 0};
            }
            int leftBound = getLeftBound(nums, target);
            if(leftBound == -1) {
                return new int[]{-1, -1};
            }
            int rightBound = getRightBound(nums, target);
            if(rightBound == -1) {
                return new int[]{-1, -1};
            }
            return new int[]{leftBound, rightBound};
        }


        private int getLeftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    right = mid;
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        private int getRightBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    left = mid + 1;
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(left - 1 < 0 || nums[left - 1] != target) {
                return -1;
            }
            return left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
