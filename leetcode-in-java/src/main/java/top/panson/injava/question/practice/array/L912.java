package top.panson.injava.question.practice.array;

import java.util.Arrays;

/**
 * @create 2022-03-27 23:30
 * @Author: Panson
 */
public class L912 {

    static class Solution {

        private int[] temp;

        public int[] sortArray(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        public void sort(int[] nums, int l, int r) {
            if(l == r) {
                return;
            }
            int mid = l + (r - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }

        public void merge(int[] nums, int l, int mid, int r) {
            // copy to new array
            for(int i = l; i <= r; i++) {
                temp[i] = nums[i];
            }
            // 双指针合并排序
            int p1 = l;
            int p2 = mid + 1;
            for(int i = l; i <= r; i++) {
                if(p1 == mid + 1) {
                    nums[i] = temp[p2++];
                }else if(p2 == r + 1) {
                    nums[i] = temp[p1++];
                }else if(temp[p1] < temp[p2]) {
                    nums[i] = temp[p1++];
                } else {
                    nums[i] = temp[p2++];
                }
            }
        }

        public void merge(int[] a, int[] b) {

            int m = a.length;
            int n = b.length;
            int [] res = new int[m + n];

            for(int i = 0, j = 0; i < m || j < n;) {
                if(i == m) {
                    res[i + j] = b[j++];
                } else if (j == n){
                    res[i + j] = a[i++];
                } else if (a[i] <= b[j]) {
                    res[i + j] = a[i++];
                } else {
                    res[i + j] = a[j++];
                }
            }
            System.out.println(Arrays.toString(res));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {1, 2, 3, 4};
        solution.merge(a, b);
    }
}
