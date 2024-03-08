package top.panson.injava.question.offer;

import top.panson.injava.question.commondata.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @create 2022-06-05 17:25
 * @Author: Panson
 */
public class L048 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {


        private String NULL = "#";
        private String SPLIT = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer res = new StringBuffer();
            preOrder(root, res);
            return res.toString();
        }

        public void preOrder(TreeNode root, StringBuffer res) {
            if(root == null) {
                res.append(NULL).append(SPLIT);
                return;
            }
            res.append(root.val).append(SPLIT);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] arr = data.split(SPLIT);
            List<String> nodes = new LinkedList<>(Arrays.asList(arr));
            return deserialize(nodes);
        }

        private TreeNode deserialize(List<String> nodes) {
            if(nodes.isEmpty()) {
                return null;
            }
            String node = nodes.remove(0);
            if(NULL.equals(node)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}
