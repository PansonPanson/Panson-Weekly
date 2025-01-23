package top.panson.injava.code.question.tags.difarray;

/**
 * @author Panson
 * @create 2024-03-12
 */
public class L1094 {

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] timestamp = new int[1001]; // 1001是因为题目给定了时间范围为 [0, 1000]
            // 记录每个时间点上的乘客数量变化
            for (int[] trip : trips) {
                timestamp[trip[1]] += trip[0]; // 上车点增加乘客数量
                timestamp[trip[2]] -= trip[0]; // 下车点减少乘客数量
            }

            // 遍历每个时间点，检查容量是否足够
            int currentCapacity = 0;
            for (int number : timestamp) {
                currentCapacity += number;
                if (currentCapacity > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}
