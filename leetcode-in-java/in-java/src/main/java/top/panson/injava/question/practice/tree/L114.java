package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-19 22:33
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
            while(root != null) {
                if(root.left == null) {
                    root = root.right;
                } else {
                    // 查找左子树的最右节点
                    TreeNode pre = root.left;
                    while(pre.right != null) {
                        pre= pre.right;
                    }
                    // 将右子树移动至左子树最右节点的右节点
                    pre.right = root.right;
                    // 左子树移动至右节点
                    root.right = root.left;
                    root.left = null;
                    // 遍历下一个节点
                    root = root.right;
                }
            }



        }
    }
}
