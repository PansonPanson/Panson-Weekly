package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-08-03
 */
public class L645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                // 4321
                // 0123
                while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            int a = -1, b = -1;
            for(int i = 0; i < n; i++) {
                if(nums[i] != i + 1) {
                    a = nums[i];
                    b = i == 0 ? 1 : nums[i - 1] + 1;
                }
            }
            return new int[]{a, b};
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }
}
