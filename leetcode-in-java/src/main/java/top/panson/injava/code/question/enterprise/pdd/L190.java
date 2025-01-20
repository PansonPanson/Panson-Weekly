package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-20
 */
public class L190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            return Integer.reverse(n);
        }
    }


    public class Solution1 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for(int i = 0; i < 32; i++) {
                // 按位与&的作用：当两个操作数的对应位都为1时，才是1
                // 此处取最后一位
                int last = n & 1;
                // 按位或｜的作用：当两个操作数的对应位至少有一个为1，则为1
                // 倒序
                res = res << 1 | last;
                n = n >> 1;
            }
            return res;
        }
    }
}
