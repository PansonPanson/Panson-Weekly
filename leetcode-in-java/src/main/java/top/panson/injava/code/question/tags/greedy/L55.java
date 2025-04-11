package top.panson.injava.code.question.tags.greedy;

/**
 * @author Panson
 * @create 2025-04-11
 */
// 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
public class L55 {
    // [3,2,1,0,4]
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length == 0) {
                return true;
            }
            int end = nums[0];
            int i = 0;
            while(i <= end) {
                if(i == nums.length - 1) {
                    break;
                }
                end = Math.max(end, i + nums[i]);
                i++;
            }
            return end >= nums.length - 1;
        }
    }

    public class Solution1 {
        public boolean canJump(int[] nums) {
            int maxReach = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) return false;
                maxReach = Math.max(maxReach, i + nums[i]);
            }

            return true;
        }
    }


}
