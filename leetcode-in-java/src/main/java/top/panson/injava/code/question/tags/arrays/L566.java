package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-18
 */
public class L566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            int count = m * n;
            if(count != r * c) {
                return mat;
            }

            int[][] res = new int[r][c];
            for(int i = 0; i < count; i++) {
                int origini = i / n;
                int originj = i % n;
                int curi = i / c;
                int curj = i % c;
                res[curi][curj] = mat[origini][originj];
            }
            return res;
        }
    }
}
