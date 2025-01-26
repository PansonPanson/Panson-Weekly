package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-26
 */
public class L039 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtrack(candidates, path, 0, target, 0, res);
            return res;
        }

        public void backtrack(int[] candidates, List<Integer> path, int start, int target, int sum, List<List<Integer>> res) {
            if(sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if(sum > target) {
                return;
            }
            for(int i = start; i < candidates.length; i++) {
                sum += candidates[i];
                path.add(candidates[i]);
                backtrack(candidates, path, i, target, sum, res);
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
