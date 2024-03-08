package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-11 18:56
 * @Author: Panson
 */
public class L695 {

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        public int dfs(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if(i < 0 || j < 0 || i >= m || j >= n) {
                return 0;
            }
            if(grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int left = dfs(grid, i - 1, j);
            int right = dfs(grid, i + 1, j);
            int upper = dfs(grid, i, j - 1);
            int down = dfs(grid, i, j + 1);
            return 1 + left + right + upper + down;
        }

    }
}
