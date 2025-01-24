package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-24
 */
public class L046 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, path, used, res);
            return res;
        }

        public void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
            if(path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
