package top.panson.injava.question.top100;

/**
 * @create 2022-01-20 01:44
 * @Author: Panson
 */
public class L169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int a = nums[0],b = 1;
            for(int i = 1; i < nums.length; i++) {
                if(a == nums[i]) {
                    b++;
                } else if(b > 0){
                    b--;
                } else {
                    a = nums[i];
                    b++;
                }
            }
            return a;
        }
    }
}
