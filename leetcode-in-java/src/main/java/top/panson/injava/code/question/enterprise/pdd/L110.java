package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-01-16
 */
public class L110 {
    // 自顶向下
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
        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            }
            if(Math.abs(depth(root.left) - depth(root.right)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);

        }


        public int depth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
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
        class Solution1{
            public boolean isBalanced(TreeNode root) {
                return depth(root) >= 0;
            }

            public int depth(TreeNode root) {
                if(root == null) {
                    return 0;
                }
                int leftDepth = depth(root.left);
                int rightDepth = depth(root.right);
                if(leftDepth  == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
                    return -1;
                } else {
                    return Math.max(leftDepth, rightDepth) + 1;
                }

            }
        }
    }
}
