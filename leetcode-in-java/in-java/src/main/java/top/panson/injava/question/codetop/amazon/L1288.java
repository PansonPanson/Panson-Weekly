package top.panson.injava.question.codetop.amazon;

import java.util.Arrays;

/**
 * @create 2022-06-18 23:31
 * @Author: Panson
 */
public class L1288 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            int duplicate = 0;
            // 排序过后可以减少左边界的影响，因为始终满足 left 非严格递增
            Arrays.sort(intervals, (a, b) -> {
                if(a[0] == b[0]) {
                    // 左边界相等时，倒序
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            int right = intervals[0][1];
            for(int i = 1; i < intervals.length; i++) {
                // 覆盖
                if(right >= intervals[i][1]) {
                    duplicate++;
                } else if(right >= intervals[i][0] && right <= intervals[i][1]) {
                    // 相交
                    right = intervals[i][1];
                } else if(right <= intervals[i][0]) {
                    // 不相交
                    right = intervals[i][1];
                }
            }
            return intervals.length - duplicate;
        }
    }
}
