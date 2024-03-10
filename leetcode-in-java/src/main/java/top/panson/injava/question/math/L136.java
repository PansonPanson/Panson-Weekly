package top.panson.injava.question.math;

/**
 * @create 2022-06-08 18:32
 * @Author: Panson
 */
public class L136 {
    class Solution {
        public int singleNumber(int[] nums) {
            // 任何数与 0 异或都为本身
            int res = 0;
            for(int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
