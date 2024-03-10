package top.panson.injava.question.codetop.amazon;

import java.util.Arrays;

/**
 * @create 2022-06-28 14:14
 * @Author: Panson
 */
public class L322 {
    // 会超时
    class Solution00 {
        public int coinChange(int[] coins, int amount) {
            return dp(coins, amount);
        }

        public int dp(int[] coins, int amount) {
            if(amount == 0) {
                return 0;
            }
            if(amount < 0) {
                return -1;
            }
            int res = Integer.MAX_VALUE;
            for(int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if(subProblem == -1) {
                    continue;
                }
                res = Math.min(subProblem + 1, res);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    // 使用记忆数组优化
    class Solution01 {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -2);
            return dp(coins, amount);
        }

        public int dp(int[] coins, int amount) {
            if(amount == 0) {
                return 0;
            }
            if(amount < 0) {
                return -1;
            }
            //
            if(memo[amount] != -2) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;
            for(int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if(subProblem == -1) {
                    continue;
                }
                res = Math.min(subProblem + 1, res);
            }
            memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
            return memo[amount];
        }
    }

    class Solution002 {
        // memo[i] 代表凑出 i 金额的钱至少需要的硬币数目
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) {
                return 0;
            }
            if(amount < 0) {
                return -1;
            }
            memo = new int[amount + 1];
            Arrays.fill(memo, amount + 1);
            memo[0] = 0;


            for(int i = 1; i < amount + 1; i++) {
                for(int coin : coins) {
                    if(i < coin) {
                        continue;
                    }
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
            return memo[amount] == amount + 1 ? -1 : memo[amount];
        }
    }
}
