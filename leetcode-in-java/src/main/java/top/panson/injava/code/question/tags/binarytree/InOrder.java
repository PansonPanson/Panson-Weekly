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
public class InOrder {

    public class SolutionRecursive {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorderRecur(root, res);
            return res;
        }

        public void inorderRecur(TreeNode root, List<Integer> res) {
            if(root == null) {
                return;
            }
            inorderRecur(root.left, res);
            res.add(root.val);
            inorderRecur(root.right, res);
        }
    }

    public class SolutionIterator {
        public List<Integer> inorderIterator(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
            return res;
        }
    }
}
