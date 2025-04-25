package top.panson.injava.code.question.tags.sort;

import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2025-04-25
 */
public class IL1714 {
    class Solution {
        public int[] smallestK(int[] arr, int k) {

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int num : arr) {
                queue.offer(num);
            }

            int[] res = new int[k];
            for(int i = 0; i < k; i++) {
                int num = queue.poll();
                res[i] = num;
            }
            return res;
        }
    }
}
