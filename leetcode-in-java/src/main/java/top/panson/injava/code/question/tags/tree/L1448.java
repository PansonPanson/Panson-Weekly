package top.panson.injava.code.question.tags.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-21
 */
public class L1448 {

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
        public int goodNodes(TreeNode root) {
            traverse(root, root.val);
            return res;
        }

        public void traverse(TreeNode root, int max) {
            if(root == null) {
                return;
            }
            if(max <= root.val) {
                res++;
            }
            max = Math.max(root.val, max);
            traverse(root.left, max);
            traverse(root.right, max);
        }
    }
}
