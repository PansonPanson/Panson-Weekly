package top.panson.injava.deprecated.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L070 {
    class Solution {

        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            if(n <= 2) {
                return n;
            }

            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }


    class Solution1 {

        public int climbStairs(int n) {

            if(n <= 2) {
                return n;
            }

            int pre_pre = 1;
            int pre = 2;
            int cur = 3;
            for(int i = 3; i <= n; i++) {
                cur = pre + pre_pre;
                int tmp = pre;
                pre = cur;
                pre_pre = tmp;
            }
            return cur;
        }
    }
}
