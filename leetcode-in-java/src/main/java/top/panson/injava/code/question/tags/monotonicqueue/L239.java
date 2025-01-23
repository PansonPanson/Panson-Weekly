package top.panson.injava.code.question.tags.monotonicqueue;

import java.util.ArrayDeque;
import java.util.Deque;
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

    /**
     * 使用单调队列，更优
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int index = 0;
        for(int i = 0; i < n; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            while(!q.isEmpty() && i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            q.offerLast(i);

            if(i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}
