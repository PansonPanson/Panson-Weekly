package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-15
 */
public class L69 {
    class Solution {
        public int mySqrt(int x) {
            if(x < 2) {
                return x;
            }
            int left = 1;
            int right = x / 2;
            int result = 0;

            while(left <= right) {
                int mid = left + (right -left) / 2;
                long square = (long) mid * mid;
                if(square == x) {
                    return mid;
                } else if(square < x) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }
}
