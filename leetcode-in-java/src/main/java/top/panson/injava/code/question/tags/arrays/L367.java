package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-15
 */
public class L367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0, right = num;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                long square = (long) mid * mid;
                if (square < num) {
                    left = mid + 1;
                } else if (square > num) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
