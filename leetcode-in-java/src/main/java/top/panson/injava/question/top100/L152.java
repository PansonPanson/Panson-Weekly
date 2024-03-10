package top.panson.injava.question.top100;

/**
 * @create 2022-01-20 00:28
 * @Author: Panson
 */
public class L152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for (int num : nums) {
                if (num < 0) {
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(imax * num, num);
                imin = Math.min(imin * num, num);

                max = Math.max(max, imax);
            }
            return max;
        }
    }
}
