package top.panson.injava.question.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2022-01-20 18:04
 * @Author: Panson
 */
public class L448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int length = nums.length;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                int currentNum = (nums[i] - 1) % length + 1;
                nums[currentNum - 1] += length;
            }
            for (int i = 0; i < length; i++) {
                if (nums[i] < length + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }

    }

}
