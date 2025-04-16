package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-03-06
 */
public class L64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];

            // **** base case ****
            dp[0][0] = grid[0][0];

            for (int i = 1; i < m; i++)
                dp[i][0] = dp[i - 1][0] + grid[i][0];

            for (int j = 1; j < n; j++)
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            // *******************

            // 状态转移
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    ) + grid[i][j];
                }
            }

            return dp[m - 1][n - 1];
        }
    }


    class Solution2 {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else if(i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if(j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
