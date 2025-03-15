package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L036 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int num : nums) {
                // 任何一个数与本身异或，结果为 0， 任何一个数与 0 异或，结果都为本身
                res ^= num;
            }
            return res;
        }
    }
}
