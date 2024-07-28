package top.panson.injava.tags.math;

/**
 * @author Panson
 * @create 2024-07-28
 */
public class L136 {

    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
