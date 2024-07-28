package top.panson.injava.tags.math;

/**
 * @author Panson
 * @create 2024-07-28
 */
public class L268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int res = nums.length;
            for(int i = 0; i < nums.length; i++) {
                res = res ^ nums[i] ^ i;
            }
            return res;
        }
    }
}
