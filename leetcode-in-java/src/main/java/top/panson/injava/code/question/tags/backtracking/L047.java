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


    // // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
// 假设输入为 nums = [1,2,2']，标准的全排列算法会得出如下答案：

// [
//     [1,2,2'],[1,2',2],
//     [2,1,2'],[2,2',1],
//     [2',1,2],[2',2,1]
// ]
// 显然，这个结果存在重复，比如 [1,2,2'] 和 [1,2',2] 应该只被算作同一个排列，但被算作了两个不同的排列。

// 所以现在的关键在于，如何设计剪枝逻辑，把这种重复去除掉？

// 答案是，保证相同元素在排列中的相对位置保持不变。

// 比如说 nums = [1,2,2'] 这个例子，我保持排列中 2 一直在 2' 前面。

// 这样的话，你从上面 6 个排列中只能挑出 3 个排列符合这个条件：

// [ [1,2,2'],[2,1,2'],[2,2',1] ]
// 这也就是正确答案。

// 进一步，如果 nums = [1,2,2',2'']，我只要保证重复元素 2 的相对位置固定，比如说 2 -> 2' -> 2''，也可以得到无重复的全排列结果。

// 仔细思考，应该很容易明白其中的原理：

// 标准全排列算法之所以出现重复，是因为把相同元素形成的排列序列视为不同的序列，但实际上它们应该是相同的；而如果固定相同元素形成的序列顺序，当然就避免了重复。

// 那么反映到代码上，你注意看这个剪枝逻辑：

// // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
// if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
//     // 如果前面的相邻相等元素没有用过，则跳过
//     continue;
// }
// // 选择 nums[i]
// 当出现重复元素时，比如输入 nums = [1,2,2',2'']，2' 只有在 2 已经被使用的情况下才会被选择，同理，2'' 只有在 2' 已经被使用的情况下才会被选择，这就保证了相同元素在排列中的相对位置保证固定。


    class Solution1 {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            traverse(nums, new ArrayList<>(), new boolean[nums.length]);
            return res;
        }

        void traverse(int[] nums, List<Integer> path, boolean[] used) {
            if(path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                traverse(nums, path, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }





}
