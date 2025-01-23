package top.panson.injava.code.question.tags.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-21
 */
public class L513 {
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
        int maxDepth;
        int res;
        public int findBottomLeftValue(TreeNode root) {
            res = root.val;
            maxDepth = 0;
            traverse(root, 1);
            return res;
        }

        public void traverse(TreeNode root, int curDepth) {
            if(root == null) {
                return;
            }
            // 同一层中最先遍历到的是最左节点
            if(curDepth > maxDepth) {
                maxDepth = curDepth;
                res = root.val;
            }
            traverse(root.left, curDepth + 1);
            traverse(root.right, curDepth + 1);
        }
    }
}
