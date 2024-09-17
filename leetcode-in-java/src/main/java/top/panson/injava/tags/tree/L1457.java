package top.panson.injava.tags.tree;

import top.panson.injava.tags.commondata.TreeNode;

/**
 * @author Panson
 * @create 2024-09-17
 */
public class L1457 {
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

        int res = 0;
        int[] count = new int[10];
        public int pseudoPalindromicPaths (TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }

            if(root.left == null && root.right == null) {
                // 叶子节点
                count[root.val]++;
                int oddCount = getOddCount(count);
                if(oddCount <= 1) {
                    res++;
                }
                count[root.val]--;
            }

            count[root.val]++;
            traverse(root.left);
            traverse(root.right);
            count[root.val]--;
        }

        public int getOddCount(int[] count) {
            int oddCount = 0;
            for(int num : count) {
                if(num % 2 != 0) {
                    oddCount++;
                }
            }
            return oddCount;
        }
    }
}
