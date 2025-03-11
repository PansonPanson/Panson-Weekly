package top.panson.injava.code.question.tags.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-03-11
 */
public class L435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
            int count = 0;
            int preEnd = intervals[0][1];
            for(int i = 1; i < intervals.length; i++) {
                if(preEnd > intervals[i][0]) {
                    count++;
                } else {
                    preEnd = intervals[i][1];
                }
            }
            return count;
        }
    }
}
