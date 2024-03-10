package top.panson.injava.question.practice.tree.bst;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-05-29 22:58
 * @Author: Panson
 */
public class L538 {

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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }

    }
}
