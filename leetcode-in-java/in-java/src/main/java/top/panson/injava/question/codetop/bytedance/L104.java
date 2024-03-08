package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @create 2022-06-12 12:30
 * @Author: Panson
 */
public class L104 {

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
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return 1 + Math.max(leftMax, rightMax);
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
    // 前序迭代
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
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
    // 中序迭代
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while(!stack.isEmpty() || cur != null) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.right != null) {
                    cur = node.right;
                }
            }
            return res;
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
    // 后序迭代
    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack1 = new ArrayDeque<>();
            Deque<TreeNode> stack2 = new ArrayDeque<>();
            stack1.push(root);
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                stack2.push(node);
                if(node.left != null) {
                    stack1.push(node.left);
                }
                if(node.right != null) {
                    stack1.push(node.right);
                }
            }
            while(!stack2.isEmpty()) {
                res.add(stack2.pop().val);
            }
            return res;

        }
    }
}
