package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-27
 */
public class L004 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int totalLength = nums1.length + nums2.length;

            if (totalLength % 2 == 1) {
                // 奇数长度，返回中间那个数
                return findKth(nums1, 0, nums2, 0, totalLength / 2 + 1);
            } else {
                // 偶数长度，返回中间两个数的平均值
                int left = findKth(nums1, 0, nums2, 0, totalLength / 2);
                int right = findKth(nums1, 0, nums2, 0, totalLength / 2 + 1);
                return (left + right) / 2.0;
            }
        }

        // 找第k小的数
        private int findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
            if (index1 >= nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 >= nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int midVal1 = (index1 + k / 2 - 1 < nums1.length) ? nums1[index1 + k / 2 - 1] : Integer.MAX_VALUE;
            int midVal2 = (index2 + k / 2 - 1 < nums2.length) ? nums2[index2 + k / 2 - 1] : Integer.MAX_VALUE;

            if (midVal1 < midVal2) {
                return findKth(nums1, index1 + k / 2, nums2, index2, k - k / 2);
            } else {
                return findKth(nums1, index1, nums2, index2 + k / 2, k - k / 2);
            }
        }
    }

}
