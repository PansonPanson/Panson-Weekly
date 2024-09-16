package top.panson.injava.tags.tree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-16
 */
public class L988 {

    public class Solution {
        String res = null;
        StringBuilder path = new StringBuilder();
        public String smallestFromLeaf(TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            // 如果到达叶子节点
            if(root.left == null && root.right == null) {
                path.append((char)('a' + root.val));
                path.reverse();
                String tmp = path.toString();
                if(res == null || res.compareTo(tmp) > 0) {
                    res = tmp;
                }
                path.deleteCharAt(0);
                path.reverse();
                return;
            }
            path.append((char)('a' + root.val));
            traverse(root.left);
            traverse(root.right);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
