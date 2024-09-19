package top.panson.injava.tags.tree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-19
 */
public class L993 {
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

        int x,y;
        TreeNode parrentX = null;
        TreeNode parrentY = null;
        int depthX = 0;
        int depthY = 0;

        public boolean isCousins(TreeNode root, int x, int y) {
            this.x = x;
            this.y = y;
            traverse(root, 0, null);
            if(depthX == depthY && parrentX != parrentY) {
                return true;
            }
            return false;
        }

        public void traverse(TreeNode root, int depth, TreeNode parent) {
            if(root == null) {
                return;
            }

            if(root.val == x) {
                parrentX = parent;
                depthX = depth;
            }

            if(root.val == y) {
                parrentY = parent;
                depthY = depth;
            }

            traverse(root.left, depth + 1, root);
            traverse(root.right, depth + 1, root);

        }
    }
}
