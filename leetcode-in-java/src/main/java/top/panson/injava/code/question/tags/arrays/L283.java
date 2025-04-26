package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-26
 */
public class L283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(nums[i] != 0) {
                    nums[slow] = nums[i];
                    slow++;
                }
            }
            for(int i = slow; i < n; i++) {
                nums[i] = 0;
            }
        }
    }

}
