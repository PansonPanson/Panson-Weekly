package top.panson.injava.question.codetop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-09 17:07
 * @Author: Panson
 */
public class L146 {

    class LRUCache {

        Node tail;
        Node head;
        Map<Integer, Node> map;
        int capacity;
        int size;
        public class Node {
            Node pre;
            Node next;
            int val;
            int key;
            public Node(int key, int val) {
                this.val = val;
                this.key = key;
            }

            public Node() {

            }
        }

        public LRUCache(int capacity) {
            tail = new Node();
            head = new Node();
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node != null) {
                node.val = value;
                moveToHead(node);
            } else {
                if(size >= capacity) {
                    Node remove = removeNode(tail.pre);
                    map.remove(remove.key);
                    size--;
                }
                size++;
                node = new Node(key, value);
                map.put(key, node);
                addToHead(node);
            }
        }

        public Node removeNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            return node;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
