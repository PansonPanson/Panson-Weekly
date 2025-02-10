package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-02-10
 */
public class L343 {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1; // 1 不能拆分，故 dp[1] 无意义

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }

}
