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
            TreeNode lastVisited = null;
            TreeNode cur = root;
            Deque<TreeNode> stack = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            while(cur != null || !stack.isEmpty()) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode peek = stack.peek();
                if(peek.right != null && peek.right != lastVisited) {
                    cur = peek.right;
                } else {
                    lastVisited = stack.pop();
                    res.add(lastVisited.val);

                }
            }
            return  res;

        }

    }


}
