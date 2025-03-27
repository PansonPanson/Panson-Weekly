package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-06-05
 */
public class L543 {

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
//    class Solution {
//
//        int length = 0;
//
//        public int diameterOfBinaryTree(TreeNode root) {
//            if(root == null) {
//                return 0;
//            }
//            length = Math.max(length, maxDepth(root.left) + maxDepth(root.right));
//            diameterOfBinaryTree(root.left);
//            diameterOfBinaryTree(root.right);
//            return length;
//        }
//
//        public int maxDepth(TreeNode root) {
//            if(root == null) {
//                return 0;
//            }
//            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//        }
//    }


    class Solution {
        int res = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return res;
        }

        public int depth(TreeNode root) {
            if(root == null) {
                return 0;
            }

            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            res = Math.max(res, leftDepth + rightDepth);
            return Math.max(leftDepth , rightDepth) + 1;
        }
    }
}
