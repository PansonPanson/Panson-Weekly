package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-05-15 13:33
 * @Author: Panson
 */
public class L931 {


    class Solution {
        int[][] memo;
        public int minFallingPathSum(int[][] matrix) {
            int length = matrix.length;
            if(length == 1) {
                return matrix[0][0];
            }
            memo = new int[length][length];
            for(int i = 0; i < length; i++) {
                Arrays.fill(memo[i], 66666);
            }

            int res = Integer.MAX_VALUE;
            for(int j = 0; j < length; j++) {
                res = Math.min(res, dp(matrix, length - 1, j));
            }
            return res;
        }

        public int dp(int[][] matrix, int i, int j) {
            int length = matrix.length;
            if(i < 0 || i > length - 1 || j < 0 || j > length - 1) {
                return 99999;
            }
            if(i == 0) {
                return matrix[0][j];
            }
            if(memo[i][j] != 66666) {
                return memo[i][j];
            }
            memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
            return memo[i][j];
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
}