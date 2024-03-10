package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.*;

/**
 * @create 2022-08-22 15:24
 * @Author: Panson
 */
public class L655 {

    /**
     * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
     *
     * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
     * 矩阵的列数 n 应该等于 2height+1 - 1 。
     * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
     * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
     * 继续这一过程，直到树中的所有节点都妥善放置。
     * 任意空单元格都应该包含空字符串 "" 。
     * 返回构造得到的矩阵 res 。
     *
     */
    class Solution {
        private final String BLANK = "";
        private int height = 0;
        int m = 0;
        int n = 0;
        int r = 0;
        int c = 0;
        private final List<List<String>> res = new ArrayList<>();
        public List<List<String>> printTree(TreeNode root) {
            height = traverse(root) - 1;
            m = height + 1;
            n = (int)Math.pow(2, height + 1) - 1;
            r = 0;
            c = (n - 1) / 2;
            fill();
            build(root, r, c);
            return res;
        }

        private void fill() {
            for(int i = 0; i < m; i++) {
                List<String> currentLevel = new ArrayList<>(n);
                for(int j = 0; j < n; j++) {
                    currentLevel.add(BLANK);
                }
                res.add(currentLevel);
            }
        }

        private void build(TreeNode root, int r, int c) {
            if(root == null) {
                return;
            }
            res.get(r).set(c, String.valueOf(root.val));
            build(root.left, r + 1, (int) (c - Math.pow(2, height - r -1)));
            build(root.right, r + 1, (int) (c + Math.pow(2, height - r -1)));
        }


        private int traverse(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftHeight = traverse(root.left);
            int rightHeight = traverse(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }



//        private void build(TreeNode root, int r, int c,  int currentHeight) {
//            if(root == null) {
//                return;
//            }
//            Deque<TreeNode> level = new ArrayDeque<>();
//            level.offer(root);
//            while(!level.isEmpty()) {
//                TreeNode node = level.poll();
//                List<String> currentLevel = new ArrayList<>(n);
//                for(int i = 0; i < n; i++) {
//
//                }
//            }
//        }
    }
}
