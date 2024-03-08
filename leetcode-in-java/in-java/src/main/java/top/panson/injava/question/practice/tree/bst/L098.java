package top.panson.injava.question.practice.tree.bst;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-05-30 14:54
 * @Author: Panson
 */
public class L098 {

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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if(root == null) {
                return true;
            }
            if(min != null && root.val <= min.val) {
                return false;
            }
            if(max != null && root.val >= max.val) {
                return false;
            }
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }
}
