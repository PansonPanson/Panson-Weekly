package top.panson.injava.code.question.tags.binarytree;

import javafx.util.Pair;
import top.panson.injava.code.question.tags.commondata.TreeNode;
import top.panson.injava.code.question.utils.A;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-03-17
 */
public class PostOrder {
    public class SolutionRecursive {

        public List<Integer> postOrder(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            postOrderRecursive(root, res);
            return res;

        }

        private void postOrderRecursive(TreeNode root, List<Integer> res) {
            if(root == null) {
                return;
            }
            postOrderRecursive(root.left, res);
            postOrderRecursive(root.right, res);
            res.add(root.val);
        }
    }


    public class SolutionIterator {

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
            stack.push(new Pair<>(root, false));

            while (!stack.isEmpty()) {
                Pair<TreeNode, Boolean> pair = stack.pop();
                TreeNode node = pair.getKey();
                boolean visited = pair.getValue();

                if (node == null) {
                    continue;
                }

                if (visited) {
                    res.add(node.val);
                } else {
                    // 先压入根节点（标记已访问）
                    stack.push(new Pair<>(node, true));
                    // 后压入右子树（未访问）
                    stack.push(new Pair<>(node.right, false));
                    // 最后压入左子树（未访问）
                    stack.push(new Pair<>(node.left, false));
                }
            }
            return res;
        }

    }


}
