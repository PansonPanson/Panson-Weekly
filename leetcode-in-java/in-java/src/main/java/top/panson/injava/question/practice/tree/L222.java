package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-05 17:50
 * @Author: Panson
 */
public class L222 {
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
        public int countNodes(TreeNode root) {
            if(root == null) {
                return 0;
            }
            TreeNode p = root;
            int hLeft = 0;
            while(p != null) {
                p = p.left;
                hLeft++;
            }
            TreeNode q = root;
            int hRight = 0;
            while(q != null) {
                q = q.right;
                hRight++;
            }
            if(hLeft == hRight) {
                return (int)Math.pow(2, hRight) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
