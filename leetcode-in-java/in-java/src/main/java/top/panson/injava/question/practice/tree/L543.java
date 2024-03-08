package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-22 14:05
 * @Author: Panson
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
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            calculate(root);
            return ans - 1;
        }

        public int calculate(TreeNode root) {
            if(root == null) {
                return 0;
            } else {
                int leftMax = calculate(root.left);
                int rightMax = calculate(root.right);
                ans =  Math.max(leftMax + rightMax + 1, ans);
                return Math.max(leftMax, rightMax) + 1;
            }
        }
    }
}
