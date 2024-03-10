package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-03-22 16:16
 * @Author: Panson
 */
public class L652 {

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

        private List<TreeNode> res = new ArrayList<>();
        private Map<String, Integer> memo = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return res;
        }

        public String traverse(TreeNode root) {
            if(root == null) {
                return "#";
            }
            String left = traverse(root.left);
            String right = traverse(root.right);
            String subTree = left + "," + right + "," + root.val;
            int count = memo.getOrDefault(subTree, 0);
            if(count == 1) {
                res.add(root);
            }
            memo.put(subTree, count + 1);
            return subTree;
        }
    }
}
