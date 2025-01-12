package top.panson.injava.deprecated.question.enterprise.pdd;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L226 {
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
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        public void invert(TreeNode root) {
            if(root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
    }
}
