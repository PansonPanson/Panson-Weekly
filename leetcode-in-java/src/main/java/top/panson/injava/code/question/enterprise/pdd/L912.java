package top.panson.injava.code.question.enterprise.pdd;

import java.util.Random;

/**
 * @author Panson
 * @create 2025-01-22
 */
public class L912 {
    class Solution {

        Random random = new Random();
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            sortArray(nums, 0, n - 1);
            return nums;
        }


        public void sortArray(int[] nums, int l, int r) {
            if(l >= r) {
                return;
            }
            int p = partition(nums, l, r);
            sortArray(nums, l, p - 1);
            sortArray(nums, p + 1, r);
        }

        public int partition(int[] nums, int l, int r) {
            shuffer(nums, l, r);
            int pivot = nums[r];
            int i = l;
            for(int j = l; j < r; j++) {
                if(nums[j] < pivot) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[r];
            nums[r] = tmp;
            return i;
        }

        public void shuffer(int[] nums, int l, int r) {
            if(l < r) {
                int index = l + random.nextInt(r - l);
                int tmp = nums[index];
                nums[index] = nums[r];
                nums[r] = tmp;
            }
        }

    }
}
