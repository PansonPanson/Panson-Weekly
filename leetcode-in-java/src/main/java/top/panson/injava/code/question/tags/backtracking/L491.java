package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @create 2025-04-02 
* @author Panson
*/
public class L491 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            traverse(nums, new ArrayList<>(), 0);
            return res;
        }

        void traverse(int[] nums, List<Integer> path, int start) {
            if(path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            Set<Integer> used = new HashSet<>();
            for(int i = start; i < nums.length; i++) {
                if(path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                    continue;
                }
                if(used.contains(nums[i])) {
                    continue;
                }
                used.add(nums[i]);
                path.add(nums[i]);
                traverse(nums, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
