package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-08-15 23:42
 * @Author: Panson
 */
public class L623 {

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
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if(depth == 1) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            } else {
                recursion(root, val, depth - 1);
                return root;
            }
        }

        public void recursion(TreeNode root, int val, int depth) {
            if(root == null) {
                return;
            }
            if(depth == 1) {
                TreeNode newLeft = new TreeNode(val);
                newLeft.left = root.left;
                root.left = newLeft;
                TreeNode newRight = new TreeNode(val);
                newRight.right = root.right;
                root.right = newRight;
            } else {
                recursion(root.left, val, depth - 1);
                recursion(root.right, val, depth - 1);
            }
        }

    }
}
