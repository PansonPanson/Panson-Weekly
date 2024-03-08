package top.panson.injava.question.practice.dp;

/**
 * @create 2022-05-22 16:32
 * @Author: Panson
 */
public class L1143 {

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int length1 = text1.length();
            int length2 = text2.length();
            int[][] dp = new int[length1 + 1][length2 + 1];
            for(int i = 1; i <= length1; i++) {
                for(int j = 1; j <= length2; j++) {
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[length1][length2];
        }
    }
}
