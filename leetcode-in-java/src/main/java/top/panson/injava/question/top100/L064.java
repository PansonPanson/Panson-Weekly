package top.panson.injava.question.top100;

/**
 * @create 2022-01-18 14:31
 * @Author: Panson
 */
public class L064 {
    class Solution {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(i == 0 && j == 0) {
                    } else if(i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if(j == 0) {
                        grid[i][j] += grid[i- 1][j];
                    } else {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}
