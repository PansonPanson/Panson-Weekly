package top.panson.injava.question.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @create 2022-01-18 17:01
 * @Author: Panson
 */
public class L094 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorder(res, root);
//        return res;
//    }
//
//    public void inorder(List<Integer> res, TreeNode root) {
//        if(root == null) {
//            return;
//        }
//        inorder(res, root.left);
//        res.add(root.val);
//        inorder(res, root.right);
//    }

}
