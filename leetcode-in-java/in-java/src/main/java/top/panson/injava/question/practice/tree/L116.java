package top.panson.injava.question.practice.tree;

import top.panson.injava.question.commondata.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @create 2022-03-14 23:45
 * @Author: Panson
 */
public class L116 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            connectTwoNode(root.left, root.right);
            return root;
        }

        public void connectTwoNode(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }
            node1.next = node2;
            connectTwoNode(node1.left, node1.right);
            connectTwoNode(node2.left, node2.right);
            connectTwoNode(node1.right, node2.left);
        }
    }

    class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node current = queue.poll();
                    if (i < size - 1) {
                        current.next = queue.peek();
                    }

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            return root;
        }
    }
}
