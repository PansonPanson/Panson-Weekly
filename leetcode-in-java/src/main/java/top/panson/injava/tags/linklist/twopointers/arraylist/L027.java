package top.panson.injava.tags.linklist.twopointers.arraylist;

/**
 * @author Panson
 * @create 2024-06-03
 */
public class L027 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums.length == 0) {
                return 0;
            }

            int p1 = 0;
            int p2 = 0;

            int n = nums.length;
            while(p2 <= n - 1) {
                while(p2 <= n - 1 && nums[p2] == val) {
                    p2++;
                }
                if(p2 <= n - 1) {
                    nums[p1] = nums[p2];
                    p1++;
                    p2++;
                }
            }
            return p1;
        }
    }
}
