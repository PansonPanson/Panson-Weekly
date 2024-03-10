package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-05 19:50
 * @Author: Panson
 */
public class L235 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);
            return find(root, min, max);
        }

        private TreeNode find(TreeNode root, int min, int max) {
            if(root == null) {
                return null;
            }
            if(root.val > max) {
                return find(root.left, min, max);
            }
            if(root.val < min) {
                return find(root.right, min, max);
            }
            return root;
        }
    }
}
