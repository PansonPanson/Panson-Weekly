package top.panson.injava.tags.tree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-17
 */
public class L1022 {
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
        int path = 0;
        public int sumRootToLeaf(TreeNode root) {
            traverse(root);
            return res;
        }


        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            if(root.left == null && root.right == null) {
                res += path << 1 | root.val;
                return;
            }
            path = path << 1 | root.val;
            traverse(root.left);
            traverse(root.right);
            path = path >> 1;
        }
    }
}
