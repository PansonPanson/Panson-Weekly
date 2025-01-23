package top.panson.injava.code.question.enterprise.pdd;

import top.panson.injava.code.question.tags.commondata.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Panson
 * @create 2025-01-11
 */
public class L094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1. 一路向左，把当前节点及其左子树压入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. 弹出栈顶节点并访问
            curr = stack.pop();
            result.add(curr.val);

            // 3. 转向右子树，继续循环
            curr = curr.right;
        }
        return result;
    }

}
