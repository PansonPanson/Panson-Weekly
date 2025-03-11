package top.panson.injava.code.question.tags.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-03-11
 */
public class L452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if(points.length <= 1) {
                return points.length;
            }
            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

            int count = 1;
            int preEnd = points[0][1];
            for(int i = 1; i < points.length; i++) {
                if(preEnd < points[i][0]) {
                    count++;
                    preEnd = points[i][1];
                }
            }
            return count;

        }
    }
}
