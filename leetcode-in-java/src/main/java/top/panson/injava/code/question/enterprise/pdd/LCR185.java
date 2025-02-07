package top.panson.injava.code.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class LCR185 {
    class Solution {
        public double[] statisticsProbability(int num) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            for (int i = 2; i <= num; i++) {
                double[] tmp = new double[5 * i + 1];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        tmp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = tmp;
            }
            return dp;
        }
    }
}
