package top.panson.injava.code.question.classic150;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int n = columnTitle.length();
            int res = 0;
            int base = 26;
            for(int i = 0; i < n; i++) {
                res = res * base + (columnTitle.charAt(i) - 'A' + 1);
            }
            return res;
        }
    }
}
