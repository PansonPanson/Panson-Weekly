package top.panson.injava.question.top100;

import top.panson.injava.question.commondata.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @create 2022-01-20 20:18
 * @Author: Panson
 */
public class L543 {
    class Solution {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftDepth = dfs(root.left);
            int rightDepth = dfs(root.right);
            max = Math.max(leftDepth + rightDepth, max);
            return Math.max(leftDepth, rightDepth) + 1;
        }

    }
}
