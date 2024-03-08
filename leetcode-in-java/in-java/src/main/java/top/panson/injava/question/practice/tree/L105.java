package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-20 22:26
 * @Author: Panson
 */
public class L105 {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if(preStart > preEnd) {
                return null;
            }
            // 计算root 节点的index
            int rootVal = preorder[preStart];
            int index = 0;
            for(int i = inStart; i <= inEnd; i++) {
                if(rootVal == inorder[i]) {
                    index = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - inStart;
            root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index -1);
            root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
            return root;
        }
    }

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
    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
        }

        public TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int m, int n) {
            if(i > j || m > n) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i]);
            int index = m;
            for(int k = m; k <= n; k++) {
                if(inorder[k] == root.val) {
                    index = k;
                    break;
                }
            }
            root.left = buildTree(preorder, i + 1, i + index - m, inorder, m, index - 1);
            root.right = buildTree(preorder, i + index - m + 1, j, inorder, index + 1, n);
            return root;
        }
    }
}
