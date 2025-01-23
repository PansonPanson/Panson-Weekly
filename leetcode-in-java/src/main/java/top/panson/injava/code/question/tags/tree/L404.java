package top.panson.injava.code.question.tags.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-18
 */
public class L404 {
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
        int res = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            if(root.left != null && root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
            traverse(root.left);
            traverse(root.right);

        }
    }
}
