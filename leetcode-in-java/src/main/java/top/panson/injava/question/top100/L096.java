package top.panson.injava.question.top100;

/**
 * @create 2022-01-18 17:36
 * @Author: Panson
 */
public class L096 {

    static class Solution {


        public static void main(String[] args) {
            System.out.println(numTrees(2));
        }

        /**
         * 递推
         * @param n
         * @return
         */
        public static int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i = 2; i < n + 1; i++)
                for(int j = 1; j < i + 1; j++)
                    dp[i] += dp[j-1] * dp[i-j];

            return dp[n];
        }
    }
}
