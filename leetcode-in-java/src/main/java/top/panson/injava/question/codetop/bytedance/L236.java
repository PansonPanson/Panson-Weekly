package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-06-12 12:23
 * @Author: Panson
 */
public class L236 {

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
            if(root == null) {
                return null;
            }
            if(root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }
    }
}
