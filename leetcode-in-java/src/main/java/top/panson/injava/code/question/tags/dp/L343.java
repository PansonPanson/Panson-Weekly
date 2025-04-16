package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-16
 */
public class L343 {

    class Solution {
        public int integerBreak(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // dp: dp[i] 表示整数 i 的乘积最大值
            for(int i = 2; i <= n; i++) {
                for(int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }
}
