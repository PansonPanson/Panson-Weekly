package top.panson.injava.question.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @create 2022-09-26 19:54
 * @Author: Panson
 */
public class L452 {

    class Solution {
        public int findMinArrowShots(int[][] points) {

            if(points == null || points.length == 0) {
                return 0;
            }

            Arrays.sort(points, Comparator.comparingInt(arr -> arr[1]));

            int right = points[0][1];
            int removeCount = 0;
            for (int i = 1; i < points.length; i++) {
                if(right >= points[i][0]) {
                    removeCount++;
                } else {
                    right = points[i][1];
                }
            }
            return points.length - removeCount;
        }
    }
}
