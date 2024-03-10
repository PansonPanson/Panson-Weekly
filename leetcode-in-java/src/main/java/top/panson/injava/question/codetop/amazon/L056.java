package top.panson.injava.question.codetop.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @create 2022-06-19 15:45
 * @Author: Panson
 */
public class L056 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> res = new ArrayList<>();
            res.add(new int[]{intervals[0][0], intervals[0][1]});

            for(int i = 1; i < intervals.length; i++) {
                int left = intervals[0][0];
                int right = intervals[0][1];
                if(right < res.get(res.size() - 1)[0]) {
                    // 没有相交
                    res.add(new int[]{left, right});
                } else {
                    // 有相交，更新右边界
                    int val = res.get(res.size() - 1)[1];
                    res.get(res.size() - 1)[1] = Math.max(val, right);
                }
            }
            return res.toArray(new int[][]{});
        }
    }
}
