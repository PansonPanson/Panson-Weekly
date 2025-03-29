package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-03-29
 *
 */
public class L124 {
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
        int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            pathSum(root);
            return res;
        }

        public int pathSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftSum = Math.max(pathSum(root.left), 0);
            int rightSum = Math.max(pathSum(root.right), 0);
            int pathSum = leftSum + rightSum + root.val;
            res = Math.max(res, pathSum);
            return root.val + Math.max(leftSum, rightSum);
        }
    }


}
