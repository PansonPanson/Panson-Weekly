package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-23
 */
public class L463 {
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int perimeter = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(grid[i][j] == 0) {
                        continue;
                    }
                    perimeter += 4;
                    if(i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
            return perimeter;
        }
    }
}
