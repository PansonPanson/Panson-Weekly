package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @create 2022-01-27 16:42
 * @Author: Panson
 */
public class L145 {
    public class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            postOrder(res, root);
            return res;
        }

        private void postOrder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            postOrder(res, root.left);
            postOrder(res, root.right);
            res.add(root.val);
        }
    }

    class Solution03 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            while(!stack.isEmpty() || root != null) {
                // 遍历左子树
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 当右子树不存在或者未被访问过时
                if(root.right == null || pre == root.right) {
                    res.add(root.val);
                    pre = root;
                    // 防止再次遍历左子树
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }

            return res;
        }

    }

    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<Object> stack = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                Object pop = stack.pop();
                if(pop instanceof Integer) {
                    res.add((Integer) pop);
                } else {
                    TreeNode node = (TreeNode) pop;
                    stack.push(node.val);
                    if(node.right != null) {
                        stack.push(node.right);
                    }
                    if(node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            return res;
        }
    }

}
