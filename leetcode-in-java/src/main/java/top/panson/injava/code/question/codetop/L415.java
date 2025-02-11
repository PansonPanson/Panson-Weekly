package top.panson.injava.code.question.codetop;

/**
 * @author Panson
 * @create 2025-02-11
 */
public class L415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            while(i >= 0 || j >= 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = n1 + n2 + carry;
                carry = sum / 10;
                res.append(sum % 10);
                i--;
                j--;
            }
            if(carry == 1) {
                res.append(1);
            }
            return res.reverse().toString();
        }
    }
}
