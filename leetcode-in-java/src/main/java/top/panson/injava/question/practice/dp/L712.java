package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-05-27 01:16
 * @Author: Panson
 */
public class L712 {

    class Solution {
        int[][] memo;
        public int minimumDeleteSum(String s1, String s2) {
            memo = new int[s1.length()][s2.length()];
            for(int[] array : memo) {
                Arrays.fill(array, -1);
            }
            return minimumDeleteSum(s1, 0, s2, 0);

        }
        public int minimumDeleteSum(String s1, int m, String s2, int n) {

            int res = 0;
            if(m == s1.length()) {
                for(int j = n; j < s2.length(); j++) {
                    res += s2.charAt(j);
                }
                return res;
            }

            if(n == s2.length()) {
                for(int j = m; j < s1.length(); j++) {
                    res += s1.charAt(j);
                }
                return res;
            }

            if(memo[m][n] != -1) {
                return memo[m][n];
            }

            if(s1.charAt(m) == s2.charAt(n)) {
                memo[m][n] = minimumDeleteSum(s1, m + 1, s2, n + 1);
            } else {
                memo[m][n] = Math.min(
                        s1.charAt(m) + minimumDeleteSum(s1, m + 1, s2, n),
                        s2.charAt(n) + minimumDeleteSum(s1, m, s2, n + 1)
                );
            }
            return memo[m][n];


        }
    }
}
