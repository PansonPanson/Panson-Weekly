package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-13
 */
public class L674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int start = 0;
            int max = 1;
            for(int end = 1; end < nums.length; end++) {
                if(nums[end] > nums[end - 1]) {
                    max = Math.max(max, end - start + 1);
                } else {
                    start = end;
                }
            }
            return max;
        }
    }
}
