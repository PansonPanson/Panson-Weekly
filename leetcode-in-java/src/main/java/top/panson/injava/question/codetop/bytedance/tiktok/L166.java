package top.panson.injava.question.codetop.bytedance.tiktok;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-06 17:24
 * @Author: Panson
 */
public class L166 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fractionToDecimal(4, 333);
    }
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            // 转 long 计算，防止溢出
            long a = numerator, b = denominator;
            // 如果本身能够整除，直接返回计算结果
            if (a % b == 0) return String.valueOf(a / b);
            StringBuilder sb = new StringBuilder();
            // 如果其一为负数，先追加负号
            if (a * b < 0) sb.append('-');
            a = Math.abs(a); b = Math.abs(b);
            // 计算小数点前的部分，并将余数赋值给 a
            sb.append(String.valueOf(a / b) + ".");
            a %= b;
            Map<Long, Integer> map = new HashMap<>();
            while (a != 0) {
                // 记录当前余数所在答案的位置，并继续模拟除法运算
                map.put(a, sb.length());
                a *= 10;
                sb.append(a / b);
                a %= b;
                // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
                if (map.containsKey(a)) {
                    int u = map.get(a);
                    return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
                }
            }
            return sb.toString();
        }
    }


    class Solution1 {
        public String fractionToDecimal(int numerator, int denominator) {
            long a = numerator;
            long b = denominator;
            int remain = numerator % denominator;
            if(remain == 0) {
                return String.valueOf(a / b);
            }

            StringBuilder s = new StringBuilder();
            if(a * b < 0) {
                a = Math.abs(a);
                b = Math.abs(b);
                s.append("-");
            }
            Map<Long, Integer> map = new HashMap<>();
            s.append(a / b).append(".");
            a = a % b;
            while(a != 0) {
                map.put(a, s.length());
                a *= 10;
                s.append(a / b);
                a %= b;
                if(map.containsKey(a)) {
                    int length = map.get(a);
                    return s.substring(0, length) + "(" + s.substring(length) + ")";
                }

            }
            return s.toString();
        }
    }
}
