package top.panson.injava.question.top100;

/**
 * @create 2022-01-18 14:51
 * @Author: Panson
 */
public class L070 {

    class Solution {
        // an = an-1 + an-2
        public int climbStairs(int n) {
            if(n <= 2) {
                return n;
            }
            int p1 = 1, p2 = 2, res = 0;
            for(int i = 3; i <= n; i++) {
                res = p1 + p2;
                p1 = p2;
                p2 = res;
            }
            return res;
        }
    }
}
