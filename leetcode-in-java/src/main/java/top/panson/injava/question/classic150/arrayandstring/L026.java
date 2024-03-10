package top.panson.injava.question.classic150.arrayandstring;

/**
 * @author Panson
 * @create 2023-09-28
 */
public class L026 {


    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length <= 1) {
                return nums.length;
            }
            int p1 = 0;
            // p2 指向未处理的数
            int p2 = 1;
            // 1 1 2
            while(p2 < nums.length) {
                if(nums[p1] == nums[p2]) {
                    p2++;
                } else {
                    p1++;
                    nums[p1] = nums[p2];
                    p2++;
                }
            }
            return p1 + 1;
        }
    }
}
