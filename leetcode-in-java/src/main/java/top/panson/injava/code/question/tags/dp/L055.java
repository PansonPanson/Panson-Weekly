package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-07
 */
public class L055 {
    class Solution {
        public boolean canJump(int[] nums) {
            // 前一位置所能到达的最大位置，从 0 开始
            int maxPosition = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i > maxPosition) {
                    return false;
                }
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if(maxPosition >= nums.length - 1) {
                    return true;
                }
            }
            return true;
        }
    }
}
