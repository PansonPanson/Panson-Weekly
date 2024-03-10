package top.panson.injava.question.classic150.arrayandstring;

/**
 * @author Panson
 * @create 2023-09-17
 */
public class L027 {

    static class Solution {
        public static int removeElement(int[] nums, int val) {
            int p1 = 0;
            int p2 = nums.length - 1;
            while(p1 <= p2) {
                if(nums[p1] == val) {
                    swap(nums, p1, p2);
                    p2--;
                } else {
                    p1++;
                }
            }
            return p1;
        }

        public static void swap(int[] nums, int p1, int p2) {
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        Solution.removeElement(nums, 3);
    }
}
