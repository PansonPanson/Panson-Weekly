package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-05
 */
public class L712 {
    public class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();

            // dp[i][j] 表示 s1[0:i] 和 s2[0:j] 变成相同字符串所需的最小 ASCII 删除和
            int[][] dp = new int[m + 1][n + 1];

            // 初始化第一列（s2 为空的情况，必须删除 s1 的所有字符）
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);  // 累加删除字符的 ASCII 值
            }

            // 初始化第一行（s1 为空的情况，必须删除 s2 的所有字符）
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);  // 累加删除字符的 ASCII 值
            }

            // 通过动态规划填充 dp 数组
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        // 若 s1[i-1] 和 s2[j-1] 相等，则不需要删除当前字符
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 若 s1[i-1] 和 s2[j-1] 不相等，需要删除一个字符
                        dp[i][j] = Math.min(
                                dp[i - 1][j] + s1.charAt(i - 1), // 删除 s1[i-1]
                                dp[i][j - 1] + s2.charAt(j - 1)  // 删除 s2[j-1]
                        );
                    }
                }
            }

            // 返回最小删除和，使得 s1 和 s2 变为相同的字符串
            return dp[m][n];
        }
    }

}
