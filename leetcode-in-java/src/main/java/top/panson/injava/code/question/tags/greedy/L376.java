package top.panson.injava.code.question.tags.greedy;

/**
 * @author Panson
 * @create 2025-04-11
 */
public class L376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if(nums.length < 2) {
                return nums.length;
            }
            int res = 0;
            int preDif = nums[1] - nums[0];
            if(preDif == 0) {
                res = 1;
            } else {
                res = 2;
            }
            for(int i = 2; i < nums.length; i++) {
                int curDif = nums[i] - nums[i - 1];
                if((preDif >= 0 &&  curDif < 0) || (preDif <= 0 && curDif > 0)) {
                    res++;
                    preDif = curDif;

                }

            }
            return res;
        }
    }
}
