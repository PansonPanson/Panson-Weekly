package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-26
 */
public class L059 {

    class Solution {
        public int[][] generateMatrix(int n) {
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = n - 1;
            int cur = 1;
            int[][] res = new int[n][n];
            while(cur <= n * n) {
                for(int i = left; i <= right; i++) {
                    res[top][i] = cur;
                    cur++;
                }
                top++;
                for(int i = top; i <= bottom; i++) {
                    res[i][right] = cur;
                    cur++;
                }
                right--;

                for(int i = right; i >= left; i--) {
                    res[bottom][i] = cur;
                    cur++;
                }

                bottom--;


                for(int i = bottom; i >= top; i--) {
                    res[i][left] = cur;
                    cur++;
                }

                left++;
            }
            return res;
        }
    }
}
