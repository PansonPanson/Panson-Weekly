package top.panson.injava.question.codetop.bytedance;

import top.panson.injava.question.commondata.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @create 2022-06-12 16:42
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
            if(root == null) {
                return null;
            }
            Deque<Node> queue = new ArrayDeque<>();

            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    Node node = queue.poll();

                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    if(i < size - 1) {
                        node.next = queue.peek();
                    }
                }
                // pre.next = null;
            }
            return root;
        }
    }
}
