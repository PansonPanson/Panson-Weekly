package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 *
 * 646.最长数对链
 * @create 2022-09-03 15:04
 * @Author: Panson
 */
public class L646 {

    /**
     * 定义 dp[i] 为以 pairs[i] 为结尾的最长数对链的长度。计算 dp[i] 时，
     * 可以先找出所有的满足 pairs[i][0]>pairs[j][1] 的 j，并求出最大的 dp[j]，dp[i] 的值即可赋为这个最大值加一。
     * 这种动态规划的思路要求计算 dp[i] 时，所有潜在的 dp[j] 已经计算完成，可以先将 pairs 进行排序来满足这一要求。初始化时，dp 需要全部赋值为 1。
     */
    class Solution {
        public int findLongestChain(int[][] pairs) {
            int n = pairs.length;
            Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
