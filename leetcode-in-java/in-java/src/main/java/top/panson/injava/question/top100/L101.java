package top.panson.injava.question.top100;

/**
 * 对称二叉树
 * @create 2022-01-18 20:08
 * @Author: Panson
 */
public class L101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && check(left.left, right.right)
                && check(left.right, right.left);
    }

}
