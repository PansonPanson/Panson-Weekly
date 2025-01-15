package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Panson
 * @create 2025-01-13
 */
public class L144 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal(root, res);
            return res;
        }

        public void preorderTraversal(TreeNode root, List<Integer> res) {
            if(root == null) {
                return;
            }
            res.add(root.val);
            preorderTraversal(root.left, res);
            preorderTraversal(root.right, res);
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();

                // 访问当前节点
                result.add(node.val);

                // 先压右子节点
                if (node.right != null) {
                    stack.push(node.right);
                }

                // 再压左子节点
                if (node.left != null) {
                    stack.push(node.left);
                }
            }

            return result;
        }
    }
}
