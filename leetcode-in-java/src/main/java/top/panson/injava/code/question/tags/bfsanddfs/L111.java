package top.panson.injava.code.question.tags.bfsanddfs;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayDeque;

/**
 * @author Panson
 * @create 2024-06-21
 */
public class L111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int depth = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left == null && node.right == null) {
                        return depth;
                    }
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
        }


    }
}
