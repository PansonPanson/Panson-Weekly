package top.panson.injava.question.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 提示:
 *
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 * @create 2022-09-26 17:15
 * @Author: Panson
 */
public class L435 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,100},{11,22},{1,11},{2,12}};
        solution.eraseOverlapIntervals(arr);
    }
    static class Solution {
        /**
         * 先排序，每个区间的末尾由小到大排序
         * [[1,100],[11,22],[1,11],[2,12]]
         * @param intervals
         * @return
         */
        public int eraseOverlapIntervals(int[][] intervals) {

            if(intervals.length == 0) {
                return 0;
            }

            int removeCount = 0;

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            int right = intervals[0][1];

            for(int i = 1; i < intervals.length; i++) {
                if(right > intervals[i][0]) {
                    removeCount++;
                } else {
                    right = intervals[i][1];
                }
            }
            return removeCount;
        }
    }
}
