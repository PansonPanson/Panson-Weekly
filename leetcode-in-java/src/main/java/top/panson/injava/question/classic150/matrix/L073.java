package top.panson.injava.question.classic150.matrix;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2024-01-10
 */
public class L073 {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n  = matrix[0].length;
            // 首行标记，默认为 1，表示不置零
            int r0 = 1;
            // 首列标记，默认为 1，表示不置零
            int c0 = 1;
            for(int i = 0; i < n; i++) {
                if(matrix[0][i] == 0) {
                    r0 = 0;
                    break;
                }
            }
            for(int i = 0; i < m; i++) {
                if(matrix[i][0] == 0) {
                    c0 = 0;
                    break;
                }
            }
            // 将首行首列作为备忘录
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if(matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // 遍历第一行，如果有 0，该列置零
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0) {
                    // 首行有元素被标记为 1，该列整列被置为 0
                    for(int i = 0; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // 从第一行开始
            for(int i = 1; i < m; i++) {
                // 首列有元素被标记为 1， 该行整行被置为 0
                if(matrix[i][0] == 0) {
                    for(int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }


            if(r0 == 0) {
                for(int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }

            if(c0 == 0) {
                for(int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] { {1,1,1},{1,0,1},{1,1,1}};
//        Solution solution = new Solution();
//        solution.setZeroes(matrix);
//        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = new int[][] { {0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution solution1 = new Solution();
        solution1.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }


}
