package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-03 13:40
 * @Author: Panson
 */
public class L027 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums == null || nums.length == 0) {
                return 0;
            }
            int slow = 0;
            int fast = 0;
            while(fast < nums.length) {
                if(nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
