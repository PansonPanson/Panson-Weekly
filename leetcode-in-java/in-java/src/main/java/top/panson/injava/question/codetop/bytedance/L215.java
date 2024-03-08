package top.panson.injava.question.codetop.bytedance;

import java.util.Random;

/**
 * @create 2022-06-09 22:07
 * @Author: Panson
 */
public class L215 {
    class Solution {

        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            int l = 0;
            int r = nums.length - 1;
            int target = nums.length - k;

            while(true) {
                int index = partition(nums, l, r);
                if(index == target) {
                    return nums[index];
                } else if(index < target) {
                    l = index + 1;
                } else {
                    r = index - 1;
                }
            }
        }



        public int partition(int[] nums, int l, int r) {
            shuffer(nums, l, r);
            int pivot = nums[r];
            // i 左边为处理过的
            int i = l;
            for(int j = l; j < r; j++) {
                if(nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, r);
            return i;
        }

        public void shuffer(int[] nums, int l, int r) {
            if(l < r) {
                int index = l + random.nextInt(r - l);
                swap(nums, index, r);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }


    }
}
