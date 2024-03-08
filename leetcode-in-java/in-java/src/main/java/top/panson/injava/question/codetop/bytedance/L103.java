package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @create 2022-06-11 23:10
 * @Author: Panson
 */
public class L103 {

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

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new LinkedList<>();
        // true 表示是从左往右
        boolean flag = true;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null) {
                return res;
            }
            queue.offer(root);
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            while(!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> level = new LinkedList<>();
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(flag) {
                        level.addLast(node.val);
                    }  else {
                        level.addFirst(node.val);
                    }
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(level);
                flag = !flag;
            }
        }
    }
}
