package top.panson.injava.tags.monotonicqueue;

import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2024-03-31
 */
public class L239 {

    /**
     * 使用优先级队列
     */
    class Solution01 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 使用大根堆，每一个元素为 <index, num>
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            int i = 0;
            while(i < k) {
                priorityQueue.offer(new int[] {i, nums[i]});
                i++;
            }
            res[index++] = priorityQueue.peek()[1];

            while(i < n) {
                priorityQueue.offer(new int[] {i, nums[i]});
                while(i - priorityQueue.peek()[0] >= k) {
                    priorityQueue.poll();
                }
                res[index++] = priorityQueue.peek()[1];
                i++;
            }
            return res;
        }
    }
}
