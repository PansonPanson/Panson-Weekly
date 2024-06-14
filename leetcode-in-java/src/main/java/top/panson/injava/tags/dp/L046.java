package top.panson.injava.tags.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-14
 */
public class L046 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, track, used);
            return res;
        }

        public List<List<Integer>> backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if(nums.length == track.size()) {
                res.add(new LinkedList<>(track));
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }

                track.add(nums[i]);
                used[i] = true;
                backtrack(nums, track, used);

                track.removeLast();
                used[i] = false;
            }
            return res;
        }
    }
}
