package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-14
 */
public class L201 {

    /**
     * 寻找公共前缀
     * 由于 AND 操作会使得范围内不同位的 1 逐渐变成 0，我们要找到 left 和 right 的公共前缀（即从 left 变化到 right 过程中保持不变的高位部分）。
     *
     * 不断右移，直到 left == right
     *
     * 当 left < right 时，不断 右移 两者，去掉低位不稳定的部分。
     * 直到 left == right，说明此时的 left 和 right 具有相同的高位前缀。
     * 最后将 left 左移回原来的位置，即得到最终结果。
     */
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int count = 0;
            while(left < right) {
                left >>= 1;
                right >>= 1;
                count++;
            }
            return left << count;
        }
    }
}
