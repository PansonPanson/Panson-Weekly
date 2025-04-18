package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-05
 */
public class L518 {
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];

            // 初始化 base case: 任何金额为 0 的情况，组合方式为 1（什么都不选）
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;

            // 遍历硬币
            for (int i = 1; i <= n; i++) {
                // 遍历金额
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i-1] >= 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            return dp[n][amount];
        }
    }

    class Solution2 {
        public int change(int amount, int[] coins) {
            // dp[i][j] : 从前 i 个硬币中选择硬币，能凑出总金额 j 的组合数
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for(int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= amount; j++) {
                    if(j >= coins[i - 1]) {
                        dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][amount];
        }
    }


    class Solution3 {
        public int change(int amount, int[] coins) {
            // dp[i][j] : 从前 i 个硬币中选择硬币，能凑出总金额 j 的组合数
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for(int coin : coins) {
                for(int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }

}
