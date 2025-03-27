package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-03-27
 */
public class L236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return find(root, p, q);
        }

        // 每一次递归，都是查找以 root 为根的，等于p 或者q 的最顶部的结点
        TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return null;
            }
            if(root == p || root == q) {
                return root;
            }
            // 在左子树存在
            TreeNode targetLeft = find(root.left, p, q);
            // 在右子树存在
            TreeNode targetRight = find(root.right, p, q);
            // 左子树和右子树都存在对应的结点
            if(targetLeft != null && targetRight != null) {
                return root;
            }
            //
            return targetLeft != null ? targetLeft : targetRight;
        }

    }
}
