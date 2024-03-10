package top.panson.injava.question.codetop.bytedance;

/**
 * @create 2022-06-11 16:59
 * @Author: Panson
 */
public class L200 {

    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        res++;
                        dfs(grid, i, j, m, n);
                    }
                }
            }
            return res;
        }

        public void dfs(char[][] grid, int i , int j, int m, int n) {
            if(i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            // 已经是海水了
            if(grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i + 1, j, m, n);
            dfs(grid, i, j - 1, m, n);
            dfs(grid, i, j + 1, m, n);
        }
    }
}
