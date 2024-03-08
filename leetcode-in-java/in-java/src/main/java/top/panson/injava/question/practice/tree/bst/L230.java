package top.panson.injava.question.practice.tree.bst;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-05-29 22:33
 * @Author: Panson
 */
public class L230 {

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
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return res;
        }

        public void traverse(TreeNode root, int k) {
            if(root == null) {
                return;
            }
            traverse(root.left, k);
            count++;
            if(k == count) {
                res = root.val;
                return;
            }
            traverse(root.right, k);
        }
    }
}
