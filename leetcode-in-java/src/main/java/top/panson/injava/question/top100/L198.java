package top.panson.injava.question.top100;

/**
 * @create 2022-01-20 11:28
 * @Author: Panson
 */
public class L198 {


    class Solution {
        public int rob(int[] nums) {
            int pre = 0, cur = 0, tmp;
            for(int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }
    }

}
