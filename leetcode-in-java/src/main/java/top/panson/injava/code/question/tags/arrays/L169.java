package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int votes = 0;
            for(int num : nums) {
                if(votes == 0) {
                    res = num;
                }
                votes += num == res ? 1 : -1;
            }
            return res;

        }
    }
}
