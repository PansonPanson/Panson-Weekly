package top.panson.injava.code.question.tags.binarytree;

import top.panson.injava.code.question.tags.commondata.Node;

/**
 * @author Panson
 * @create 2025-03-25
 */
public class LCR155 {

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        Node head = null;
        Node pre = null;
        public Node treeToDoublyList(Node root) {
            inorder(root);
            // 将头尾连接成循环链表
            if(head != null && pre != null) {
                head.left = pre;
                pre.right = head;
            }

            return head;
        }

        void inorder(Node root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            if(pre == null) {
                head = root;
            } else {
                pre.right = root;
                root.left = pre;
            }
            pre = root;
            inorder(root.right);
        }
    }

}
