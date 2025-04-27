package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-27
 */
public class L59 {
    // 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



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
