package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-18
 */
public class L240 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;
            int j = n - 1;
            while(i < m && j >= 0) {
                if(matrix[i][j] == target) {
                    return true;
                } else if(matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
