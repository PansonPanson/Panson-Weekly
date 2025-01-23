package top.panson.injava.code.question.tags.presum;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-07-24
 */
public class L437 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int res;
        long targetSumMem;

        public int pathSum(TreeNode root, long targetSum) {
            targetSumMem = targetSum;
            // dfs1 用于搜索所有节点
            dfs1(root);
            return res;
        }

        void dfs1(TreeNode root) {
            if(root == null) {
                return;
            }
            // 搜索当前搜索节点为根节点的路径的路径和
            dfs2(root, root.val);
            dfs1(root.left);
            dfs1(root.right);
        }

        void dfs2(TreeNode root, long sum) {
            if(sum == targetSumMem) {
                res++;
            }
            if(root.left != null) {
                dfs2(root.left, sum + root.left.val);
            }
            if(root.right != null) {
                dfs2(root.right, sum + root.right.val);
            }
        }
    }
}
