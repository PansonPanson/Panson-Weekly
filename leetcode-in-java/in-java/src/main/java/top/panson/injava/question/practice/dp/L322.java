package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-04-02 15:43
 * @Author: Panson
 */
public class L322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int i = 0; i <= amount; i++) {
                for(int coin : coins) {
                    if( i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i],  1 + dp[i - coin]);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

    class Solution01 {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -100);
            return dp(coins, amount);
        }

        public int dp(int[] coins, int amount) {
            if(amount == 0) {
                return 0;
            }
            if(amount < 0) {
                return -1;
            }
            if(memo[amount] != -100) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;

            for(int i = 0; i < coins.length; i++) {
                int subProblem = dp(coins, amount - coins[i]);
                if(subProblem == -1) {
                    continue;
                }
                res = Math.min(res, 1 + dp(coins, amount - coins[i]));
            }
            memo[amount] =  (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }
}
