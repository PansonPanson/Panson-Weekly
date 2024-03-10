package top.panson.injava.question.top100;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @create 2022-01-20 17:36
 * @Author: Panson
 */
public class L338 {

    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n+1];
            res[0] = 0;
            for(int i= 1; i <= n; i++) {
                // 奇数比前一个偶数多 1
                if((i&1) == 1) {
                    res[i] = res[i - 1] + 1;
                } else {
                    res[i] = res[i / 2];
                }
            }
            return res;
        }
    }
}
