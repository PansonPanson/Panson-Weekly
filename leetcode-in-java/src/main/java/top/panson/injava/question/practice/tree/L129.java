package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-06 14:52
 * @Author: Panson
 */
public class L129 {
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
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode root, int pre) {
            if(root == null) {
                return 0;
            }
            pre = pre * 10 + root.val;
            if(root.left == null && root.right == null) {
                return pre;
            }
            return helper(root.left, pre) + helper(root.right, pre);
        }
    }
}
