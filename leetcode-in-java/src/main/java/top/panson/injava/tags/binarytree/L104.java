package top.panson.injava.tags.binarytree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-06-04
 */
public class L104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
