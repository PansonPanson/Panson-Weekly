package top.panson.injava.code.question.tags.dp;

/**
 * @author Panson
 * @create 2025-04-16
 */
public class L063 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if(i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if(i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if(j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
