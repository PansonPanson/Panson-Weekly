package top.panson.injava.code.question.enterprise.pdd;

/**
 * @author Panson
 * @create 2025-01-19
 */
public class L922 {
    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int i = 0;
            int j = 1;
            int n = nums.length;
            while(i < n || j < n) {

                while(i < n && nums[i] % 2 == 0) {
                    i += 2;
                }
                while(j < n && nums[j] % 2 == 1) {
                    j += 2;
                }
                if(i < n && j < n) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }

            }
            return nums;
        }
    }
}
