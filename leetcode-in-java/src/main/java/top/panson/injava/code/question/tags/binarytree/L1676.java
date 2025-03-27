package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.HashSet;

/**
 * @author Panson
 * @create 2025-03-27
 */
public class L1676 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            // 将列表转化成哈希集合，便于判断元素是否存在
            HashSet<Integer> values = new HashSet<>();
            for (TreeNode node : nodes) {
                values.add(node.val);
            }

            return find(root, values);
        }

        // 在二叉树中寻找 values 的最近公共祖先节点
        TreeNode find(TreeNode root, HashSet<Integer> values) {
            if (root == null) {
                return null;
            }
            // 前序位置
            if (values.contains(root.val)){
                return root;
            }

            TreeNode left = find(root.left, values);
            TreeNode right = find(root.right, values);
            // 后序位置，已经知道左右子树是否存在目标值
            if (left != null && right != null) {
                // 当前节点是 LCA 节点
                return root;
            }

            return left != null ? left : right;
        }
    }
}
