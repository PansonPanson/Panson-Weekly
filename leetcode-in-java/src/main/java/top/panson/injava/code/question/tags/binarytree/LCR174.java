package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-03-23
 */
public class LCR174 {
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
        public int findTargetNode(TreeNode root, int cnt) {
            List<Integer> values = new ArrayList<>();
            inorder(root, values);
            // 0 1 2 3 4  size = 5, cnt = 1,  res = 4, index = 5 - 1
            return values.get(values.size() - cnt);
        }

        public void inorder(TreeNode root, List<Integer> values) {
            if(root == null) {
                return;
            }
            inorder(root.left, values);
            values.add(root.val);
            inorder(root.right, values);
        }

    }
}
