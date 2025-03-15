package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0) {
                return false;
            }
            // n & (n - 1) 的作用：作用：消除 n 的最低位 1
            // 给定 n，n - 1 会将 n 的最低位的 1 变成 0，并将其右侧所有位变成 1。
            // 执行 n & (n - 1) 之后，n 的最低位 1 被消去，其他位保持不变。
            return (n & (n - 1)) == 0;
        }
    }
}
