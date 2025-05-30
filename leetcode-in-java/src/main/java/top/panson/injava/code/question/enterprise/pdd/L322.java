package top.panson.injava.code.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L322 {
    class Solution {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1
            Arrays.fill(dp, amount + 1);

            // base case
            dp[0] = 0;
            // dp[i]: 凑成金额 i 所需的最少硬币数
            // 外层 for 循环在遍历所有状态的所有取值，自底向上求解
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }

    }
}
