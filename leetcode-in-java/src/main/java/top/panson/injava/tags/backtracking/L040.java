package top.panson.injava.tags.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-20
 */
public class L040 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int sum = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates, 0, target);
            return res;
        }

        public void backtrack(int[] nums, int start, int target) {
            if(sum == target) {
                res.add(new LinkedList<>(track));
                return;
            }

            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if(sum + nums[i] > target) {
                    continue;
                }
                track.add(nums[i]);
                sum += nums[i];
                backtrack(nums, i + 1, target);
                sum -= nums[i];
                track.removeLast();
            }
        }
    }
}
