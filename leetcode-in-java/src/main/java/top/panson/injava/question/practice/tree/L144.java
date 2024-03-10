package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 *
 * @create 2022-01-25 17:09
 * @Author: Panson
 */
public class L144 {

    /**
     * 递归
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(res, root);
            return res;
        }

        private void preorder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preorder(res, root.left);
            preorder(res, root.right);
        }
    }

    /**
     * 迭代
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            while(!stack.isEmpty() || root != null) {
                // 遍历到最左子节点，然后pop, 遍历最左子节点的右节点
                while(root != null) {
                    res.add(root.val);
                    // 不要混用 add ，add is addLast
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return res;
        }
    }

    class Solution3 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }

            return res;
        }
    }


}
