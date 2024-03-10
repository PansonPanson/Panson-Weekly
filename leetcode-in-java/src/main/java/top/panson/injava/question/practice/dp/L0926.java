package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-05-23 21:55
 * @Author: Panson
 */
public class L0926 {

    class Solution {
        public int minFlipsMonoIncr(String s) {
            int n = s.length();
            int[][] dp = new int[n][2];
            dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
            dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
            for(int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1] + (s.charAt(i) == '1' ? 0 : 1));
            }
            return Math.min(dp[n - 1][0], dp[n - 1][1]);
        }
    }
}
