package top.panson.injava.question.practice.array;

import java.util.Arrays;

/**
 * @create 2022-03-29 21:13
 * @Author: Panson
 */
public class L304 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        NumMatrix1 numMatrix = new NumMatrix1(matrix);
        System.out.println(Arrays.deepToString(numMatrix.sums));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    }


    static class NumMatrix1 {

        private int[][] sums;
        public NumMatrix1(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            if(m == 0 || n == 0) {
                return;
            }
            sums = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    // 计算每个矩阵 [0, 0, i - 1 , j - 1] 的元素和
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] + matrix[i-1][j-1] - sums[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
        }
    }


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
