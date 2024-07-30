package top.panson.injava.deprecated.question.practice.tree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @create 2022-03-09 01:15
 * @Author: Panson
 */
public class L226 {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
