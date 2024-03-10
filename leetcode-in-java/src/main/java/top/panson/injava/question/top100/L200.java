package top.panson.injava.question.top100;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * @create 2022-01-20 11:49
 * @Author: Panson
 */
public class L200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 深度遍历并标记
         * @param grid
         * @param i
         * @param j
         */
        private void dfs(char[][] grid, int i, int j) {
            if(!inGrid(grid, i, j) || grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '2';
            dfs(grid, i -1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }

        private boolean inGrid(char[][] grid, int i, int j) {
            return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
        }
    }
}
