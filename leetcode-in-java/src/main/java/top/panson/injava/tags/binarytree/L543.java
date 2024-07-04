package top.panson.injava.tags.binarytree;

import top.panson.injava.deprecated.question.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-06-05
 */
public class L543 {

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

        int length = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null) {
                return 0;
            }
            length = Math.max(length, maxDepth(root.left) + maxDepth(root.right));
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
            return length;
        }

        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
