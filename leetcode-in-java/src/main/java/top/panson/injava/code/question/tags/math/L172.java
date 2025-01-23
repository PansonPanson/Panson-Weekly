package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-07-31
 */
public class L172 {
    class Solution {
        public int trailingZeroes(int n) {
            if(n < 5) {
                return 0;
            }
            int res = 0;
            while(n > 0) {
                n /= 5;
                res += n;
            }
            return res;
        }
    }
}
