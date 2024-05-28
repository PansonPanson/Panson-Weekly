package top.panson.injava.tags.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-05-28
 */
public class L026 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int p1= 0;
            int p2 = 0;
            while(p2 < n) {
                // 找到第一个
                while(p2 < n && nums[p1] == nums[p2]) {
                    p2++;
                }
                p1++;
                if(p2 < n) {
                    nums[p1] = nums[p2];
                }
            }
            return p1;
        }
    }
}
