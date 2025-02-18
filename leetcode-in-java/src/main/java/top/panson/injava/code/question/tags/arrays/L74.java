package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-18
 */
public class L74 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int count = m * n;
            int left = 0;
            int right = count;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int i = mid / n;
                int j = mid % n;
                if(matrix[i][j] == target) {
                    return true;
                } else if(matrix[i][j] > target) {
                    right = mid;
                } else if(matrix[i][j] < target) {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
