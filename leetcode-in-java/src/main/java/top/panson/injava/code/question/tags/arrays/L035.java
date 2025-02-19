package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-19
 */
public class L035 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left= 0;
            int right = nums.length;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    right = mid;
                } else if(nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
