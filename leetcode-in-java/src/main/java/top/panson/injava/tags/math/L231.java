package top.panson.injava.tags.math;

/**
 * @author Panson
 * @create 2024-07-28
 */
public class L231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }
}
