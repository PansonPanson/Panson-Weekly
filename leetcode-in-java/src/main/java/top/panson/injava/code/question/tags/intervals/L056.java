package top.panson.injava.code.question.tags.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Panson
 * @create 2024-04-24
 */
public class L056 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])
            );
            List<int[]> res = new ArrayList<>();
            int left = intervals[0][0];
            int right = intervals[0][1];
            for(int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                if(right < cur[0]) {
                    res.add(new int[]{left, right});
                    left = cur[0];
                    right = cur[1];
                } else {
                    right = Math.max(right, cur[1]);
                }
            }
            res.add(new int[]{left, right});
            return res.toArray(new int[res.size()][]);
        }
    }
}
