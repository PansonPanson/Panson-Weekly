package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-06 15:45
 * @Author: Panson
 */
public class L687 {
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
        int max = 0;
        public int longestUnivaluePath(TreeNode root) {
            helper(root);
            return max;
        }

        private int helper(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int lefMax = helper(root.left);
            int rightMax = helper(root.right);
            int left1 = 0; int right1 = 0;
            if(root.left != null && root.left.val == root.val) {
                left1 = lefMax + 1;
            }
            if(root.right != null && root.right.val == root.val) {
                right1 = rightMax + 1;
            }
            max = Math.max(max, left1 + right1);
            return Math.max(left1, right1);

        }
    }
}
