package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-16
 */
public class L268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int xor = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                xor ^= nums[i];
            }
            for (int i = 0; i <= n; i++) {
                xor ^= i;
            }
            return xor;
        }
    }


}
