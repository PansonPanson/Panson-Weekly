package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-04-02
 */
public class L046 {
    class Solution01 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            backTrace(res, nums, new ArrayList<>());
            return res;
        }

        public void backTrace(List<List<Integer>> res, int[] nums, List<Integer> tmpList) {
            if(tmpList.size() == nums.length) {
                res.add(new ArrayList<>(tmpList));
            } else {
                for(int i = 0; i < nums.length; i++) {
                    if(tmpList.contains(nums[i])) {
                        continue;
                    }
                    tmpList.add(nums[i]);
                    backTrace(res, nums, tmpList);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

    class Solution02 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            boolean[] used = new boolean[n];
            backTrack(res, nums, new ArrayList<>(), used);
            return res;
        }

        public void backTrack(List<List<Integer>> res, int[] nums, List<Integer> tmpList, boolean[] used) {
            if(tmpList.size() == nums.length) {
                res.add(new ArrayList<>(tmpList));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }
                used[i] = true;
                tmpList.add(nums[i]);
                backTrack(res, nums, tmpList, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }

        }
    }
}
