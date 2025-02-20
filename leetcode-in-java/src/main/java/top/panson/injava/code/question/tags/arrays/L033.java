package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-20
 */
public class L033 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(nums[mid] >= nums[left]) {
                    // left 到 mid 有序
                    if(nums[left] <= target && target < nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // mid 到 right 有序
                    if(nums[mid] < target && target <= nums[right -1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
