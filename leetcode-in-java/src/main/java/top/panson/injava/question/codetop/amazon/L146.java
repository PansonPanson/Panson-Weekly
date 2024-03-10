package top.panson.injava.question.codetop.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2022-06-16 23:09
 * @Author: Panson
 */
public class L146 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
    static class LRUCache {

        private Node head = new Node();
        private Node tail = new Node();
        private int capacity;
        private int remain;

        private Map<Integer, Node> map = new HashMap<>();

        public class Node {
            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
            int value;
            int key;
            Node next;
            Node pre;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.remain = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                removeToHead(map.get(key));
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                map.get(key).value = value;
                removeToHead(map.get(key));
                return;
            }
            Node node = new Node(key, value);
            if(remain <= 0) {
                removeNode(tail.pre);
                remain++;
            }
            addToHead(node);
            remain--;


        }

        public void removeToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            map.put(node.key, node);
        }

        public void removeNode(Node node) {
            Node pre = node.pre;
            pre.next = node.next;
            node.next.pre = pre;
            map.remove(node.key);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
