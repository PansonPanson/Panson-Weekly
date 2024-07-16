package top.panson.injava.tags.linklist.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-06-03
 */
public class L0283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int p1 = 0;
            int p2 = 0;
            while(p2 <= n - 1) {
                while(p2 <= n - 1 && nums[p2] == 0) {
                    p2++;
                }
                if(p2 <= n - 1) {
                    nums[p1] = nums[p2];
                    p1++;
                    p2++;
                }
            }
            while(p1 <= n - 1) {
                nums[p1++] = 0;
            }
        }
    }
}
