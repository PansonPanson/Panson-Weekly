package top.panson.injava.code.question.tags.backtracking;

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

    class Solution1 {

        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            traverse(candidates, target, new ArrayList<>(), 0);
            return res;
        }

        public void traverse(int[] candidates, int target, List<Integer> path, int start) {

            if(target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i = start; i < candidates.length; i++) {
                // 剪枝
                if(candidates[i] > target) {
                    break;
                }
                // 同层过滤重复数字
                if(i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.add(candidates[i]);
                traverse(candidates, target - candidates[i], path, i + 1);
                path.remove(path.size() - 1);
            }

        }
    }
}
