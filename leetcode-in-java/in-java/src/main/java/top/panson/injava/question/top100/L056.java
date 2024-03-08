package top.panson.injava.question.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @create 2022-01-17 16:54
 * @Author: Panson
 */
public class L056 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        System.out.println(JSON.toJSON(intervals));
////        Arrays.sort(intervals);
////        System.out.println(JSON.toJSON(intervals));
//        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
//        System.out.println(JSON.toJSON(intervals));
//        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
//        System.out.println(JSON.toJSON(intervals));
//        int[][] merge = merge(intervals);
//        System.out.println(JSON.toJSON(merge));

    }
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int size = res.size();
            int left = interval[0];
            int right = interval[1];
            if (size == 0 || res.get(size - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                res.get(size - 1)[1] = Math.max(right, res.get(size - 1)[1]);
            }
        }
        return res.toArray(new int[0][]);
    }

}
