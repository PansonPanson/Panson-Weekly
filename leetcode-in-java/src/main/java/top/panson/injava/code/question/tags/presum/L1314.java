package top.panson.injava.code.question.tags.presum;

/**
 * @author Panson
 * @create 2024-07-20
 */
public class L1314 {

    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] presum = new int[m][n];
            int[][] answer = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        presum[i][j] = mat[i][j];
                    } else if(i == 0) {
                        presum[i][j] = mat[i][j] + presum[i][j - 1];
                    } else if(j == 0) {
                        presum[i][j] = mat[i][j] + presum[i - 1][j];
                    } else {
                        presum[i][j] = mat[i][j] + presum[i - 1][j]  + presum[i][j - 1] - presum[i - 1][j - 1];
                    }
                }
            }
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int r1 = Math.max(0, i - k);
                    int c1 = Math.max(0, j - k);
                    int r2 = Math.min(m - 1, i + k);
                    int c2 = Math.min(n - 1, j + k);

                    if(r1 > 0  && c1 > 0) {
                        answer[i][j] = presum[r2][c2] - presum[r1 - 1][c2] - presum[r2][c1 - 1] + presum[r1 - 1][c1 - 1];
                    } else if(r1 > 0){
                        answer[i][j] = presum[r2][c2] - presum[r1 - 1][c2];
                    } else if(c1 > 0) {
                        answer[i][j] = presum[r2][c2] - presum[r2][c1 - 1];
                    } else {
                        answer[i][j] = presum[r2][c2];
                    }
                }
            }
            return answer;
        }
    }
}
