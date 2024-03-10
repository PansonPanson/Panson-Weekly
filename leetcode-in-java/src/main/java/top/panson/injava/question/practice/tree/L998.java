package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-08-30 22:25
 * @Author: Panson
 */
public class L998 {
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
     *
     *  4
     * 1 2
     *  4
     * 1  3
     *      2
     */
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            // val 如果是最大值，那么直接把原先的树设为新节点的左子树
            // 否则，遍历最右子节点，寻找临界节点
            if(root == null) {
                return new TreeNode(val);
            }
            TreeNode father = null;
            TreeNode child = root;
            while(child != null && child.val > val) {
                father = child;
                child = child.right;
            }
            // val 为最大值
            if(father == null) {
                return new TreeNode(val, child, null);
            } else {
                father.right = new TreeNode(val, child, null);
                return root;
            }
        }
    }
}
