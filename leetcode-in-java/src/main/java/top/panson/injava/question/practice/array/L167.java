package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-03 18:36
 * @Author: Panson
 */
public class L167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if(numbers ==null || numbers.length == 1){
                return null;
            }

            int left = 0;
            int right = numbers.length - 1;
            while(left < right) {
                int sum = numbers[left] + numbers[right];
                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    break;
                }
            }
            return new int[]{left + 1, right + 1};
        }
    }
}
