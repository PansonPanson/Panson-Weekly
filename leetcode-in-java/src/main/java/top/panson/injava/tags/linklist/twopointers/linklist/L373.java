package top.panson.injava.tags.linklist.twopointers.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2024-07-02
 */
public class L373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
                return a[0] + a[1] - b[0] - b[1];
            });

            for(int i = 0; i < nums1.length; i++) {
                q.offer(new int[]{nums1[i], nums2[0], 0});
            }

            List<List<Integer>> res = new ArrayList<>();
            while(!q.isEmpty() && k > 0) {
                int[] cur = q.poll();
                res.add(Arrays.asList(cur[0], cur[1]));
                if(cur[2] + 1 < nums2.length) {
                    q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
                }
                k--;
            }
            return res;

        }
    }
}
