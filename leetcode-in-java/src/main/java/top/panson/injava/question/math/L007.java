package top.panson.injava.question.math;

/**
 * @create 2022-05-26 18:50
 * @Author: Panson
 */
public class L007 {

    class Solution {
        public int reverse(int x) {
            int res = 0;
            while(x != 0) {
                if(res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int remainder = x % 10;
                x /= 10;
                res = res * 10 + remainder;
            }
            return res;
        }

    }
}
