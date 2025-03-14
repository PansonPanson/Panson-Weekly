package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-14
 */
public class L190 {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for(int i = 0; i < 32; i++) {
                // 每次取最后一位数，将已颠倒的部分 * 2 + 最后一位数
                // 取最后一位数, &（与） 运算：都为 1 才为 1，任何数与 1 相与都为本身
                int lastBit = n & 1;
                // res << 1 相当于 * 2， | lastBit 相当于加上最后一位数
                res = res << 1 | lastBit;
                n = n >> 1;
            }
            return res;

        }
    }
}
