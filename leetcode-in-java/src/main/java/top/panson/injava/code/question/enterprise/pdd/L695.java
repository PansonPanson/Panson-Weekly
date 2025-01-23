package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-23
 */
public class L695 {
    class Solution {

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int rows;
        int cols;
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            rows = grid.length;
            cols = grid[0].length;
            int ans = 0;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
            return ans;
        }

        public int dfs(int[][] grid, int r, int c) {
            if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
                return 0;
            }
            grid[r][c] = 0;
            int area = 1;
            for(int[] curDir : dir) {
                area += dfs(grid, r + curDir[0], c + curDir[1]);
            }
            return area;
        }
    }
}
