package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Panson
 * @create 2025-03-20
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) {
                return res;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int level = 0;
            while(!queue.isEmpty()) {
                List<Integer> curLevel = new LinkedList<>();
                int levelSize = queue.size();
                boolean left2Right = level % 2 == 0;
                for(int i = 0; i < levelSize; i++) {
                    TreeNode poll = queue.poll();
                    if(left2Right) {
                        curLevel.add(poll.val);
                    } else {
                        curLevel.addFirst(poll.val);
                    }
                    if(poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if(poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                level++;
                res.add(curLevel);
            }
            return res;
        }
    }
}
