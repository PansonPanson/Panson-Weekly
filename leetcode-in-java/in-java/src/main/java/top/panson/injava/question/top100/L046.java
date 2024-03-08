package top.panson.injava.question.top100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @create 2022-01-15 22:29
 * @Author: Panson
 */
public class L046 {
    //public List<List<Integer>> permute(int[] nums) {
    //        List<List<Integer>> res = new ArrayList<>();
    //        List<Integer> output = new ArrayList<>();
    //        for(int num : nums) {
    //            output.add(num);
    //        }
    //        int n = nums.length;
    //        backtrack(n, output, res, 0);
    //        return res;
    //    }
    //    void backtrack(int length, List<Integer> output, List<List<Integer>> res, int first) {
    //        // 所有数都填完了
    //        if(first == length) {
    //            res.add(new ArrayList<>(output));
    //        }
    //        for(int i = first; i < length; i++) {
    //            // 动态维护数组
    //            Collections.swap(output, first, i);
    //            // 继续递归填下一个数
    //            backtrack(length, output, res, first + 1);
    //            // 撤销操作
    //            Collections.swap(output, first, i);
    //        }
    //    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

}
