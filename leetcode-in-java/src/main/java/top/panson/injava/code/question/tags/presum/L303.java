package top.panson.injava.code.question.tags.presum;

/**
 * @author Panson
 * @create 2024-07-17
 */
public class L303 {

    class NumArray {

        int[] numsMemory;

        public NumArray(int[] nums) {
            numsMemory = new int[nums.length];
            numsMemory[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                numsMemory[i] = nums[i] + numsMemory[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if(left > right) {
                return 0;
            }
            if(left == 0) {
                return numsMemory[right];
            }
            return numsMemory[right] - numsMemory[left - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
