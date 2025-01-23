package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2024-06-12
 */
public class L509 {
    class Solution {
        public int fib(int n) {
            if(n < 2) {
                return n;
            }
            int dp0 = 0;
            int dp1 = 1;
            for(int i = 2; i <= n; i++) {
                int tmp = dp0;
                dp0 = dp1;
                dp1 = dp1 + tmp;

            }
            return dp1;
        }
    }
}
