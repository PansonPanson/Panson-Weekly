package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-15
 */
public class L167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            int p1 = 0;
            int p2 = n - 1;
            while(p1 < p2) {
                if(numbers[p1] + numbers[p2] == target) {
                    return new int[]{p1 + 1, p2 + 1};
                } else if(numbers[p1] + numbers[p2] < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
