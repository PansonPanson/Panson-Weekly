package top.panson.injava.code.question.tags.bfsanddfs;

/**
 * @author Panson
 * @create 2025-04-14
 */
public class L695 {


    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int maxArea = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        int curArea = 0;
                        curArea = dfs(grid, i, j, curArea);
                        maxArea = Math.max(curArea, maxArea);
                    }
                }
            }
            return maxArea;
        }

        public int dfs(int[][] grid, int i , int j, int curArea) {
            int m = grid.length;
            int n = grid[0].length;
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
                return curArea;
            }
            grid[i][j] = 0;
            curArea++;
            curArea = dfs(grid, i - 1, j, curArea);
            curArea = dfs(grid, i + 1, j, curArea);
            curArea = dfs(grid, i, j - 1, curArea);
            curArea = dfs(grid, i, j + 1, curArea);
            return curArea;
        }
    }


}
