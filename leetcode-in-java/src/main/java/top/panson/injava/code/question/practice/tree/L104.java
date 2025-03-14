package top.panson.injava.code.question.practice.tree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

/**
 * @create 2022-03-08 00:31
 * @Author: Panson
 */
public class L104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            } else {
                int leftMax = maxDepth(root.left);
                int rightMax = maxDepth(root.right);
                return Math.max(leftMax, rightMax) + 1;
            }
        }
    }
}
