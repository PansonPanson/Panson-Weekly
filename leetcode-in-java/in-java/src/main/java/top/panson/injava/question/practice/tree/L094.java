package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @create 2022-01-25 19:32
 * @Author: Panson
 */
public class L094 {

    public class Solution1 {
        /**
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            inorder(res, root);
            return res;
        }

        private void inorder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(res, root.left);
            res.add(root.val);
            inorder(res, root.right);
        }
    }


    /**
     * 在树的深度优先遍历中（包括前序、中序、后序遍历），递归方法最为直观易懂，但考虑到效率，我们通常不推荐使用递归。
     *
     * 栈迭代方法虽然提高了效率，但其嵌套循环却非常烧脑，不易理解，容易造成“一看就懂，一写就废”的窘况。而且对于不同的遍历顺序（前序、中序、后序），循环结构差异很大，更增加了记忆负担。
     *
     * 因此，我在这里介绍一种“颜色标记法”（瞎起的名字……），兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
     *
     * 其核心思想如下：
     *
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     *
     * 作者：hzhu212
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Deque<Object> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Object pop = stack.pop();
                if (pop instanceof Integer) {
                    res.addLast((Integer) pop);
                } else {
                    TreeNode treeNode = (TreeNode) pop;
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                    }
                    stack.push(treeNode.val);
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                    }
                }
            }
            return res;
        }
    }

    class Solution03 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            while(!stack.isEmpty() || root != null) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
            return res;
        }
    }
}
