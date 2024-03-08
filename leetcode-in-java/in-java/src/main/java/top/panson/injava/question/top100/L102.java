package top.panson.injava.question.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @create 2022-01-19 00:34
 * @Author: Panson
 */
public class L102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();
                for(int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }
}
