package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-24
 */
public class L043 {
    class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length();
            int n = num2.length();
            int[] mem = new int[m + n];
            // 从后往前遍历
            // 15 * 5 = 75 -> [000] -> i = 1, j = 0, p1 = 1, p2 = 2; [025] -> i = 0, j = 0, p1 = 0, p2 = 1; [075]
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j;
                    int p2 = i + j + 1;
                    int sum = mul + mem[p2];
                    mem[p2] = sum % 10;
                    mem[p1] += sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m + n; i++) {
                if(sb.isEmpty() && mem[i] == 0) {
                    continue;
                }
                sb.append(mem[i]);
            }
            return sb.toString();
        }
    }
}
