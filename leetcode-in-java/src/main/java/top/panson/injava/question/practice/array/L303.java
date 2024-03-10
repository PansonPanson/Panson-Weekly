package top.panson.injava.question.practice.array;

/**
 * @create 2022-03-25 21:46
 * @Author: Panson
 */
public class L303 {

    class NumArray {

        private int[] sums;
        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++) {
                // [0, i] 的和
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
