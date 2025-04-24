package top.panson.injava.code.question.tags.sort;

import java.util.Random;

/**
 * @author Panson
 * @create 2025-04-21
 */
public class L215 {


    class Solution {

        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length < k) {
                return -1;
            }
            boolean allEq = isAllEq(nums);
            if(allEq) {
                return nums[nums.length - k];
            }

            return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
        }

        private static boolean isAllEq(int[] nums) {
            boolean allEq = true;
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] != nums[i - 1]) {
                    allEq = false;
                    break;
                }
            }
            return allEq;
        }

        public int findKthLargest(int[] nums, int left, int right, int target) {
            // 123456
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, randomIndex, right);
            int index = partition(nums, left, right);
            if(index == target) {
                return nums[index];
            } else if(index > target) {
                return findKthLargest(nums, left, index - 1, target);
            } else {
                return findKthLargest(nums, index + 1, right, target);
            }


        }

        public int partition(int[] nums, int left, int right) {
            int p = right;
            int i = left;
            for(int j = left; j < right; j++) {
                if(nums[j] <= nums[p]) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, p);
            return i;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
