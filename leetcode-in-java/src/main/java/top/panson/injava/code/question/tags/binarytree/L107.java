package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Panson
 * @create 2025-03-20
 */
public class L107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> level = new LinkedList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                // 把每一层添加到头部，就是自底向上的层序遍历。
                res.addFirst(level);
            }
            return res;
        }
    }

}
