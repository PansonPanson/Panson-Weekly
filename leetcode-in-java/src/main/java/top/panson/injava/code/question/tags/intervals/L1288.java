package top.panson.injava.code.question.tags.intervals;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2024-04-22
 */
public class L1288 {

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if(a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });

            int left = intervals[0][0];
            int right = intervals[0][1];
            int count = 0;
            for(int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                if(left <= cur[0] && right >= cur[1]) {
                    count++;
                } else if(right >= cur[0] && right <= cur[1]) {
                    right = cur[1];
                } else {
                    left = cur[0];
                    right = cur[1];
                }
            }
            return intervals.length - count;
        }
    }
}
