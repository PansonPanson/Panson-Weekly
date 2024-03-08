package top.panson.injava.question.top100;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * @create 2022-01-20 19:49
 * @Author: Panson
 */
public class L461 {

    class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x^y);
        }
    }
}
