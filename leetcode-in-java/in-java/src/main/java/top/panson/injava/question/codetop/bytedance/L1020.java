package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-11 18:30
 * @Author: Panson
 */
public class L1020 {
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            for(int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m - 1, j);
            }
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }

        public void dfs(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if(i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if(grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
