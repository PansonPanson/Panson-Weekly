package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2022-05-18 17:15
 * @Author: Panson
 */
public class L297 {

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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer res = new StringBuffer();
            serialize(root, res);
            return res.toString();
        }

        public void serialize(TreeNode root, StringBuffer res) {
            if(root == null) {
                res.append("#").append(",");
                return;
            } else {
                res.append(root.val).append(",");
            }
            serialize(root.left, res);
            serialize(root.right, res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strArray = data.split(",");
            List<String> nodes = new ArrayList<>(Arrays.asList(strArray));
            return deserialize(nodes);
        }

        public TreeNode deserialize(List<String> nodes) {
            if(nodes.isEmpty()) {
                return null;
            }
            String first = nodes.remove(0);
            if("#".equals(first)) {
                return  null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
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
