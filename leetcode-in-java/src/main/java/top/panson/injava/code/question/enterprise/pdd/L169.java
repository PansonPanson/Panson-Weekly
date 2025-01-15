package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-12
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
