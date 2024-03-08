package top.panson.injava.question.top100;

import top.panson.injava.question.commondata.TreeNode;

import java.util.LinkedList;

/**
 * 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @create 2022-01-21 00:56
 * @Author: Panson
 */
public class L617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }

    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }


    class Solution {

        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            //如果 t1和t2中，只要有一个是null，函数就直接返回
            if (t1 == null || t2 == null) {
                return t1 == null ? t2 : t1;
            }
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(t1);
            queue.add(t2);
            while (queue.size() > 0) {
                TreeNode r1 = queue.remove();
                TreeNode r2 = queue.remove();
                r1.val += r2.val;
                //如果r1和r2的左子树都不为空，就放到队列中
                //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
                if (r1.left != null && r2.left != null) {
                    queue.add(r1.left);
                    queue.add(r2.left);
                } else if (r1.left == null) {
                    r1.left = r2.left;
                }
                //对于右子树也是一样的
                if (r1.right != null && r2.right != null) {
                    queue.add(r1.right);
                    queue.add(r2.right);
                } else if (r1.right == null) {
                    r1.right = r2.right;
                }
            }
            return t1;
        }
    }


}
