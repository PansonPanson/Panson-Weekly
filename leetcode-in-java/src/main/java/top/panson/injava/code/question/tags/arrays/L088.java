package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-27
 */
public class L088 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int index = m + n - 1;
            while(p1 >= 0 && p2 >= 0) {
                if(nums1[p1] > nums2[p2]) {
                    nums1[index] = nums1[p1];
                    index--;
                    p1--;
                } else {
                    nums1[index] = nums2[p2];
                    index--;
                    p2--;
                }
            }
            if(p1 >= 0) {
                while(p1 >= 0) {
                    nums1[index] = nums1[p1];
                    index--;
                    p1--;
                }
            }
            if(p2 >= 0) {
                while(p2 >= 0) {
                    nums1[index] = nums2[p2];
                    index--;
                    p2--;
                }
            }
        }
    }
}
