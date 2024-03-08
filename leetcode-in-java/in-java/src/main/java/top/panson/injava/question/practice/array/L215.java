package top.panson.injava.question.practice.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @create 2022-03-28 13:07
 * @Author: Panson
 */
public class L215 {

    static class Solution {

        public static void main(String[] args) {
            System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }

        // 大根堆
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : nums) {
                queue.offer(num);
            }
            while (k-- > 1) {
                queue.poll();
            }
            return queue.poll();
        }
    }

    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                priorityQueue.offer(num);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
            return priorityQueue.poll();
        }
    }

    class Solution3 {

        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;
            // 第 k 大，等于第 nums.length - k + 1小，从 0 开始计数的话，再减一
            int target = nums.length - k;

            while (true) {
                int q = patition(nums, left, right);
                if (q == target) {
                    return nums[q];
                } else if (q < target) {
                    // 在q右侧
                    left = q + 1;
                } else {
                    right = q - 1;
                }
            }
        }

        public int patition(int[] nums, int left, int right) {
            if (right > left) {
                int randomIndex = left + random.nextInt(right - left);
                swap(nums, randomIndex, right);
            }

            int i = left;
            for (int j = left; j < right; j++) {
                if (nums[j] < nums[right]) {
                    swap(nums, i++, j);
                }
            }
            swap(nums, i, right);
            return i;

        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a -b);
            for(int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
            }
            while(queue.size() > k) {
                queue.poll();
            }
            return queue.poll();
        }
    }
}
