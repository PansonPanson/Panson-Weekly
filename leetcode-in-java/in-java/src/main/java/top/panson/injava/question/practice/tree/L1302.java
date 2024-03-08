package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @create 2022-08-17 10:24
 * @Author: Panson
 */
public class L1302 {
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
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int levelSum = 0;
            Deque<TreeNode> level = new ArrayDeque<>();
            level.offer(root);
            while (!level.isEmpty()) {
                int levelSize = level.size();
                levelSum = 0;
                for(int i = 0; i < levelSize; i++) {
                    TreeNode node = level.poll();
                    levelSum += node.val;
                    if (node.left != null) {
                        level.offer(node.left);
                    }
                    if(node.right != null) {
                        level.offer(node.right);
                    }
                }
                
            }
            return levelSum;
        }
    }

}
