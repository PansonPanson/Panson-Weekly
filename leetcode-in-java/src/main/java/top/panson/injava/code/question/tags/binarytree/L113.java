package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-03-21
 */
public class L113 {

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
        List<List<Integer>> res = new ArrayList<>();
        int targetSum;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            traverse(root, new ArrayList<>());
            return res;
        }

        void traverse(TreeNode root, List<Integer> path) {
            if(root == null) {
                return;
            }
            path.add(root.val);
            if(root.left == null && root.right == null) {
                int sum = 0;
                for(int num : path) {
                    sum += num;
                }
                if(sum == targetSum) {
                    res.add(new ArrayList<>(path));
                }
            }
            if(root.left != null) {
                traverse(root.left, path);
            }
            if(root.right != null) {
                traverse(root.right, path);
            }
            path.removeLast();



        }
    }
}
