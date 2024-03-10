package top.panson.injava.question.practice.array;

/**
 * @create 2022-09-05 10:16
 * @Author: Panson
 */
public class L1582 {

    class Solution {
        public int numSpecial(int[][] mat) {
            int res = 0;
            int rowsSum[] = new int[mat.length];
            int columSum[] = new int[mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    rowsSum[i] += mat[i][j];
                    columSum[j] += mat[i][j];
                }
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1 && rowsSum[i] == 1 && columSum[j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
