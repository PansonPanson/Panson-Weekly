package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.*;

/**
 * @author Panson
 * @create 2025-03-20
 */
public class L257 {
    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root, "");
            return res;
        }

        public void traverse(TreeNode root, String path) {
            if(root == null) {
                return;
            }
            path += root.val;
            if(root.left == null && root.right == null){
                res.add(path);
            } else {
                path += "->";
                traverse(root.left, path);
                traverse(root.right, path);
            }
        }
    }

    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            List<String> path = new ArrayList<>();
            traverse(root, path, res);
            return res;
        }

        void traverse(TreeNode root, List<String> path, List<String> res) {
            if (root == null) return;

            path.add(String.valueOf(root.val));

            if (root.left == null && root.right == null) {
                res.add(String.join("->", path));
            } else {
                traverse(root.left, path, res);
                traverse(root.right, path, res);
            }
            path.removeLast();  // 回溯
        }
    }




    class SolutionBFS {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;

            Deque<TreeNode> nodeQueue = new LinkedList<>();
            Deque<String> pathQueue = new LinkedList<>();

            nodeQueue.offer(root);
            pathQueue.offer(String.valueOf(root.val));

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                String path = pathQueue.poll();

                if (node.left == null && node.right == null) {
                    result.add(path);  // 叶子节点，加入结果
                }

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }

            return result;
        }
    }









}
