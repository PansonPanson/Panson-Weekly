package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-03 15:56
 * @Author: Panson
 */
public class L283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums == null || nums.length == 0) {
                return;
            }
            int slow = 0;
            int fast= 0;
            //  11000223
            while(fast < nums.length) {
                if(nums[fast] != 0) {
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                    slow++;
                }
                fast++;
            }
        }
    }
}
