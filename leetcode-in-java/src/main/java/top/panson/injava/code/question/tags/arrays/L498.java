package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-27
 */
public class L498 {
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int cur = 0;
            int[] res = new int[m * n];
            int col = 0;
            int row = 0;
            int dir = 1;
            while(cur < m * n) {
                res[cur] = mat[row][col];
                cur++;
                if(dir == 1) {
                    if(col == n - 1) {
                        row++;
                        dir = -1;
                    } else if(row == 0) {
                        col++;
                        dir = -1;
                    }  else {
                        row--;
                        col++;
                    }
                } else {
                    if(row == m - 1) {
                        col++;
                        dir = 1;
                    } else if(col == 0) {
                        row++;
                        dir = 1;
                    }  else {
                        row++;
                        col--;
                    }
                }
            }
            return res;
        }
    }
}
