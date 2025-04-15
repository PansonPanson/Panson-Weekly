package top.panson.injava.code.question.tags.binarysearch;

/**
 * @author Panson
 * @create 2025-04-15
 */
public class L240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;
            int j = n - 1;
            while(i >= 0 && i < m && j >= 0 && j < n) {
                if(matrix[i][j] == target) {
                    return true;
                } else if(matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
