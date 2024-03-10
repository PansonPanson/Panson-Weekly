package top.panson.injava.question.practice.tree;

/**
 * @create 2022-06-05 21:54
 * @Author: Panson
 */
public class L215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            int l = 0;
            int h = nums.length - 1;
            k = nums.length - k;
            while(l <= h) {
                int p = partition(nums, l, h);
                if(p < k) {
                    l = p + 1;
                } else if( p > k) {
                    h = p - 1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        private int partition(int[] nums, int l, int h) {
            int pivot = nums[h];
            int i = l;
            for(int j = l; j < h; j++) {
                if(nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, h);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}
