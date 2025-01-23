package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-21
 */
public class L039 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int sum = 0;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, 0, target);
            return res;
        }

        public void backtrack(int[] candidates, int start, int target) {
            if(sum == target) {
                res.add(new LinkedList<>(track));
                return;
            }

            if(sum > target) {
                return;
            }

            for(int i = start; i < candidates.length; i++) {
                sum += candidates[i];
                track.add(candidates[i]);
                backtrack(candidates, i, target);
                sum -= candidates[i];
                track.removeLast();
            }
        }
    }
}
