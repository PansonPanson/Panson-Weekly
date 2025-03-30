package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-03-30
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
        Map<Integer, Integer> val2Index = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i = 0; i < inorder.length; i++) {
                val2Index.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
            if(preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootVal = preOrder[preStart];
            int index = val2Index.get(rootVal);
            int leftSize = index - inStart;

            TreeNode root = new TreeNode(preOrder[preStart]);

            root.left = buildTree(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, index - 1);
            root.right = buildTree(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd);
            return root;
        }
    }
}
