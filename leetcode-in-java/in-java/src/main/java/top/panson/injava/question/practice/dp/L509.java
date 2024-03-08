package top.panson.injava.question.practice.dp;

/**
 * @create 2022-03-31 21:38
 * @Author: Panson
 */
public class L509 {

    class Solution {
        public int fib(int n) {
            if(n < 2) {
                return n;
            }
            int pre = 0;
            int cur = 1;
            int tmp;
            for(int i = 2; i <= n; i++) {
                tmp = cur;
                cur = pre + cur;
                pre = tmp;
            }
            return cur;
        }
    }
}
