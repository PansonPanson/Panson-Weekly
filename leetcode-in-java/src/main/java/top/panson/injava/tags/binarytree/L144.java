package top.panson.injava.tags.binarytree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-06-04
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

        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null) {
                return res;
            }
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return res;
        }
    }
}
