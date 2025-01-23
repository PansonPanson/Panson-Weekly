package top.panson.injava.code.question.tags.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-19
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
        int curDepth = 0;
        int nodeVal;
        int nodeDepth;
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            nodeVal = val;
            nodeDepth = depth;
            if(depth == 1) {
                TreeNode newNode = new TreeNode(nodeVal, root, null);
                return newNode;
            }
            traverse(root);
            return root;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            curDepth++;
            if(curDepth == nodeDepth - 1) {
                TreeNode newNodeLeft = new TreeNode(nodeVal, root.left, null);
                TreeNode newNodeRight = new TreeNode(nodeVal, null, root.right);
                root.left = newNodeLeft;
                root.right = newNodeRight;
            }
            traverse(root.left);
            traverse(root.right);
            curDepth--;
        }
    }
}
