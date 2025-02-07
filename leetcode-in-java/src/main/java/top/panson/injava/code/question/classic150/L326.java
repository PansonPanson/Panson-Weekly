package top.panson.injava.code.question.classic150;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            while(n != 0 && n % 3  == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }
}
