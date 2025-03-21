package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-03-21
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
        int res = 0;
        public int sumNumbers(TreeNode root) {
            traverse(root, "" + root.val);
            return res;
        }

        void traverse(TreeNode root, String path) {
            if(root.left == null && root.right == null) {
                res += Integer.parseInt(path);
                return;
            }
            if(root.left != null) {
                traverse(root.left, path + root.left.val);
            }
            if(root.right != null) {
                traverse(root.right, path + root.right.val);
            }
        }
    }
}
