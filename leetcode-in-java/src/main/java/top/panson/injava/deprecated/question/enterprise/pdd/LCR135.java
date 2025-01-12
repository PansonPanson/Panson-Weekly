package top.panson.injava.deprecated.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class LCR135 {
    class Solution {
        public int[] countNumbers(int cnt) {
            int max = (int)Math.pow(10, cnt) - 1;
            int[] res = new int[max];
            for(int i = 0; i < max; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
}
