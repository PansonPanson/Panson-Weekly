package top.panson.injava.question.codetop.bytedance.tiktok;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-06 14:23
 * @Author: Panson
 */
public class L124 {
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
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxSum;
        }

        public int dfs(TreeNode root) {
            // 后序遍历
            if(root == null) {
                return 0;
            }
            int left = Math.max(dfs(root.left), 0);
            int right = Math.max(dfs(root.right), 0);
            int pathMax = root.val + left + right;
            maxSum = Math.max(pathMax, maxSum);
            return Math.max(left, right) + root.val;
        }
    }
}
