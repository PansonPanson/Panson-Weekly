package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-21
 */
public class L047 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
         *
         * 示例 1：
         *
         * 输入：nums = [1,1,2]
         * 输出：
         * [[1,1,2],
         *  [1,2,1],
         *  [2,1,1]]
         * 示例 2：
         *
         * 输入：nums = [1,2,3]
         * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
         * 提示：
         *
         * 1 <= nums.length <= 8
         * -10 <= nums[i] <= 10
         *
         * @param nums
         * @return
         */
        // 1 1 1 2
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }


        public void backtrack(int[] nums) {
            if(track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }
                if(i > 0 && nums[i] == nums[i - 1] && !used[i]) {
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
