package top.panson.injava.code.question.tags.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-21
 */
public class L1261 {

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
    class FindElements {
        TreeNode root;
        int target;
        boolean res = false;

        public FindElements(TreeNode root) {
            root.val = 0;
            this.root = root;
            traverse(root);
        }

        public boolean find(int target) {
            this.target = target;
            res = false;
            traverseFind(this.root);
            return res;
        }

        public void traverseFind(TreeNode root) {
            if(root == null) {
                return;
            }
            if(root.val == target) {
                res = true;
                return;
            }
            traverseFind(root.left);
            traverseFind(root.right);
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            if(root.left != null) {
                root.left.val = root.val * 2 + 1;
            }

            if(root.right != null) {
                root.right.val = root.val * 2 + 2;

            }
            traverse(root.left);
            traverse(root.right);

        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
