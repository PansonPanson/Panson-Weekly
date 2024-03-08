package top.panson.injava.question.codetop.amazon;

/**
 * @create 2022-06-27 22:53
 * @Author: Panson
 */
public class L509 {

    class Solution {
        public int fib(int n) {
            if(n < 2) {
                return n;
            }
            int a = 0;
            int b = 1;
            for(int i = 2; i <= n; i++) {
                int tmp = a;
                a = b;
                b = tmp + a;
            }
            return b;
        }
    }
}
