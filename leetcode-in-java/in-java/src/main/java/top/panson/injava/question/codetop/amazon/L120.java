package top.panson.injava.question.codetop.amazon;

import java.util.Arrays;
import java.util.List;

/**
 * @create 2022-06-20 23:56
 * @Author: Panson
 */
public class L120 {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            // 经典dp：dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            // 边界情况：三角形左边界的数只能从上一行的左边界移动下来。
            int size = triangle.size();
            int[][] dp = new int[size][triangle.get(size - 1).size()];
            for(int i = 0; i < triangle.size(); i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            // 初始状态
            dp[0][0] = triangle.get(0).get(0);
            for(int i = 1; i < triangle.size(); i++) {
                List<Integer> currentLevel = triangle.get(i);
                for(int j = 0; j < currentLevel.size(); j++) {
                    // 左边界
                    if(j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) +  triangle.get(i).get(j);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < dp[0].length; i++) {
                min = Math.min(min, dp[size - 1][i]);
            }
            return min;
        }
    }
}
