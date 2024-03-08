package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-21 01:05
 * @Author: Panson
 */
public class L889 {

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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
            if(preStart > preEnd) {
                return null;
            }
            if(preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
            int index = 0;
            int rootVal = preorder[preStart];
            int leftRootVal = preorder[preStart + 1];
            for(int i = postStart; i < postEnd; i++) {
                if(leftRootVal == postorder[i]) {
                    index = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - postStart + 1;
            root.left = buildTree(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
            root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
            return root;
        }
    }
}
