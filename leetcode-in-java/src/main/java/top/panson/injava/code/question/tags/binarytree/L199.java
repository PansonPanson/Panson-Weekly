package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Panson
 * @create 2025-03-29
 */
public class L199 {


    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    // 只记录每层最后一个节点
                    if (i == size - 1) {
                        result.add(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
        }
    }

}
