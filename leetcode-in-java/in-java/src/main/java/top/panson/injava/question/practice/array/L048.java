package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-04 13:25
 * @Author: Panson
 */
public class L048 {
    class Solution {
        // m n 相同
        public void rotate(int[][] matrix) {
            // 1 2 3   7 4 1
            // 4 5 6   8 5 2
            // 7 8 9   9 6 3
            reverse(matrix);
            reverseRow(matrix);
        }

        private void reverse(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        private void reverseRow(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] =tmp;
                }
            }
        }
    }
}
