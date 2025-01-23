package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-20
 */
public class L090 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {
            res.add(new LinkedList<>(track));

            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
}
