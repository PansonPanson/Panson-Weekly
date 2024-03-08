package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-03 13:05
 * @Author: Panson
 */
public class L026 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null) {
                return 0;
            }
            int slow = 0;
            int fast = 0;
            int length = nums.length;
            // 1223445
            while(fast < length) {
                if(nums[slow] == nums[fast]) {
                    fast++;
                } else {
                    slow++;
                    nums[slow] = nums[fast];
                    fast++;
                }

            }
            return slow + 1;
        }
    }
}
