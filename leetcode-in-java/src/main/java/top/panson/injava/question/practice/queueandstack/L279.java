package top.panson.injava.question.practice.queueandstack;

/**
 * 完全平方数
 *
 * @create 2022-02-23 00:25
 * @Author: Panson
 */
public class L279 {

    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                dp[i] = i;
                for(int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
