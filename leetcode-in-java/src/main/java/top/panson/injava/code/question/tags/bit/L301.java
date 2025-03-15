package top.panson.injava.code.question.tags.bit;

/**
 * @author Panson
 * @create 2025-03-15
 */
public class L301 {
    class Solution {
        public int getSum(int a, int b) {
            // 每次只计算无进位和，如果进位为 0，说明已经累加结束
            while(b != 0) {
                // 异或^：不同为 1，相同为 0
                int sumWithoutCarry = a ^ b;
                int carry = (a & b) << 1;
                a = sumWithoutCarry;
                b = carry;
            }
            return a;
        }
    }
}
