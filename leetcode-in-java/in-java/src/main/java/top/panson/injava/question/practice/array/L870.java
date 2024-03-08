package top.panson.injava.question.practice.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @create 2022-06-05 14:26
 * @Author: Panson
 */
public class L870 {

    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    nums1.length, (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]
            );
            for(int i = 0; i < nums2.length; i++) {
                queue.offer(new int[]{i, nums2[i]});
            }
            int[] res = new int[nums1.length];
            Arrays.sort(nums1);
            int right = nums1.length - 1;
            int left = 0;
            while(!queue.isEmpty()) {
                int[] pair = queue.poll();
                int index = pair[0];
                int value = pair[1];
                if(nums1[right] > value) {
                    res[index] = nums1[right];
                    right--;
                } else {
                    res[index] = nums1[left];
                    left++;
                }
            }
            return res;
        }
    }}
