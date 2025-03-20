package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-03-20
 */
public class LevelOrder {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return new ArrayList<>();
            }
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<List<Integer>> res = new ArrayList<>();
            while(!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> curLevel = new ArrayList<>();
                for(int i = 0; i < levelSize; i++) {
                    TreeNode poll = queue.poll();
                    curLevel.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                res.add(curLevel);
            }
            return res;
        }
    }
}
