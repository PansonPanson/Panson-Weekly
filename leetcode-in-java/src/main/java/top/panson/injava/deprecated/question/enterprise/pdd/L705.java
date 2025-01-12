package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L705 {
    class MyHashSet {

        int[] values;
        public MyHashSet() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        public void add(int key) {
            values[key] = key;
        }

        public void remove(int key) {
            values[key] = -1;
        }

        public boolean contains(int key) {
            return values[key] != -1;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
