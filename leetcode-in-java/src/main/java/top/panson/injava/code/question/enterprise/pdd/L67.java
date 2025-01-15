package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-13
 */
public class L67 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int i = a.length() - 1; // 指向 a 的最后一位
            int j = b.length() - 1; // 指向 b 的最后一位
            int carry = 0; // 进位

            while (i >= 0 || j >= 0 || carry != 0) {
                // 当前位的数字
                int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
                int digitB = j >= 0 ? b.charAt(j) - '0' : 0;

                // 当前位的总和
                int sum = digitA + digitB + carry;

                // 更新进位
                carry = sum / 2;

                // 当前位结果
                result.append(sum % 2);

                // 移动指针
                i--;
                j--;
            }

            // 结果需要反转
            return result.reverse().toString();
        }
    }
}
