package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-08 23:02
 * @Author: Panson
 */
public class L112 {


    /**
     * dfs
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) {
                return false;
            }
            // 叶子节点
            if(root.left == null && root.right == null) {
                return targetSum == root.val;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
