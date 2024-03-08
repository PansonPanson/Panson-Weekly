package top.panson.injava.question.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-01-11 21:25
 * @Author: Panson
 */
public class L001 {
    static class Solution {
        public static void main(String[] args) {
            int[] res = twoSum(new int[]{1, 2, 3, 4}, 7);
            System.out.println(Arrays.toString(res));
        }

        /**
         * 本质是哈希
         * @param nums
         * @param target
         * @return
         */
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
