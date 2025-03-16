package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-03-16
 */
public class PreOrder {

    public class SolutionReCursive {
        public List<Integer> preOrder(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            reCur(root, res);
            return res;
        }

        public void reCur(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            reCur(root.left, res);
            reCur(root.right, res);
        }
    }

    public class SolutionIterator {
        public List<Integer> preOrder(TreeNode root) {
            if(root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.offer(root);
            while(!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                res.add(pop.val);

                if(pop.right != null) {
                    stack.push(pop.right);
                }
                if(pop.left != null) {
                    stack.push(pop.left);
                }
            }
            return res;
        }
    }

}
