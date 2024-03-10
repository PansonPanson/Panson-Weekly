package top.panson.injava.question.math;

/**
 * @create 2022-06-08 20:39
 * @Author: Panson
 */
public class L231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1))  == 0;
        }
    }
}
