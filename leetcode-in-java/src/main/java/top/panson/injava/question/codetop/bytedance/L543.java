package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-12 13:38
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

        int maxDiameter = Integer.MIN_VALUE;

        public int diameterOfBinaryTree(TreeNode root) {
            traverse(root);
            return maxDiameter;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            int leftMax = maxLength(root.left);
            int rightMax = maxLength(root.right);
            maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
            traverse(root.left);
            traverse(root.right);
        }

        public int maxLength(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftMax = maxLength(root.left);
            int rightMax = maxLength(root.right);
            return 1 + Math.max(leftMax, rightMax);
        }
    }

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
    // 优化
    class Solution1 {

        int maxDiameter = Integer.MIN_VALUE;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return maxDiameter;
        }

        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
            return 1 + Math.max(leftMax, rightMax);
        }
    }

}
