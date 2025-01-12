package top.panson.injava.deprecated.question.enterprise.pdd;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-01-12
 */
public class L706 {
    class MyHashMap {

        int[] values;
        public MyHashMap() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        public void put(int key, int value) {
            values[key] = value;
        }

        public int get(int key) {
            return values[key];
        }

        public void remove(int key) {
            values[key] = -1;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
