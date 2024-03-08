package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-12 15:41
 * @Author: Panson
 */
public class L114 {
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
        public void flatten(TreeNode root) {
            if(root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;
            TreeNode p = root;
            while(p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
}
