package top.panson.injava.code.question.tags.binarysearch;

/**
 * @author Panson
 * @create 2025-04-15
 */
public class L074 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0;
            int right = m * n - 1;
            return searchMatrix(matrix, target, left, right);

        }

        public boolean searchMatrix(int[][] matrix, int target, int left, int right) {
            int m = matrix.length;
            int n = matrix[0].length;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(matrix[mid / n][mid % n] == target) {
                    return true;
                } else if(matrix[mid / n][mid % n] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
