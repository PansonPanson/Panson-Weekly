package top.panson.injava.question.classic150.arrayandstring;

/**
 * 88. 合并两个有序数组
 *
 * @author Panson
 * @create 2023-09-17
 */
public class L088 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int tail = m + n - 1;
            int cur;

            // 从后往前，双指针
            while (p1 >= 0 || p2 >= 0) {
                if(p1 == -1) {
                    cur = nums2[p2];
                    p2--;
                } else if(p2 == -1) {
                    cur = nums1[p1];
                    p1--;
                } else if(nums1[p1] <= nums2[p2]) {
                    cur = nums2[p2];
                    p2--;
                } else {
                    cur = nums1[p1];
                    p1--;
                }
                nums1[tail--] = cur;
            }
        }
    }
}
