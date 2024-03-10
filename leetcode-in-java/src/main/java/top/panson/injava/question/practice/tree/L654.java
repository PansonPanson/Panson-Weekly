package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

/**
 * @create 2022-03-19 23:23
 * @Author: Panson
 */
public class L654 {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return  constructMaximumBinaryTree(nums, 0, nums.length);
        }

        public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
            if(left == right) {
                return null;
            }
            int maxIndex = getMaxIndex(nums, left, right);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = constructMaximumBinaryTree(nums, left, maxIndex);
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);
            return root;
        }

        public int getMaxIndex(int[] nums, int left, int right) {
            int maxIndex = left;
            for(int i = left; i < right; i++) {
                if(nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
}
