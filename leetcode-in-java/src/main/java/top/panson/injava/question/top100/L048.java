package top.panson.injava.question.top100;

/**
 * 给定一个n x n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2022-01-16 00:05
 * @Author: Panson
 */
public class L048 {

    /**
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        // 水平翻转
        for(int i= 0; i < size / 2; i++) {
            for(int j = 0; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size -i - 1][j] = temp;
            }
        }

        // 对角线替换
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }









//     public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        // 右上角
//        // transpose matrix
//        for (int i = 0; i < n; i++) {
//          for (int j = i; j < n; j++) {
//            int tmp = matrix[j][i];
//            matrix[j][i] = matrix[i][j];
//            matrix[i][j] = tmp;
//          }
//        }
//        // reverse each row
//        for (int i = 0; i < n; i++) {
//          for (int j = 0; j < n / 2; j++) {
//            int tmp = matrix[i][j];
//            matrix[i][j] = matrix[i][n - j - 1];
//            matrix[i][n - j - 1] = tmp;
//          }
//        }
//      }
}
