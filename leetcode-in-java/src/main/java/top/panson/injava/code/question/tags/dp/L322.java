package top.panson.injava.code.question.tags.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-02-11
 */
public class L322 {


    class Solution {
        public int coinChange(int[] coins, int amount) {
            // dp[i][j] : 从前 i 种硬币中凑出总金额为 j 所需的最少硬币数
            // dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for(int j = 1; j <= amount; j++) {
                dp[0][j] = amount + 1;
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= amount; j++) {
                    if(j >= coins[i - 1]) {
                        dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] =  dp[i - 1][j];
                    }
                }
            }
            return dp[n][amount] > amount ? -1: dp[n][amount];
        }
    }



    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            // dp[i][j] : 从前 i 种硬币中凑出总金额为 j 所需的最少硬币数
            // dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
            int n = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int coin : coins) {
                for(int j = coin; j <= amount; j++) {
                    dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

}
