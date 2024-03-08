package top.panson.injava.question.math;

/**
 * @create 2022-06-08 19:16
 * @Author: Panson
 */
public class L197 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while(n != 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
}
