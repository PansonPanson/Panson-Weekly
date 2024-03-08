package top.panson.injava.question.practice.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @create 2022-06-05 16:06
 * @Author: Panson
 */
public class L380 {

    class RandomizedSet {

        private Map<Integer, Integer> valueToIndexMap;
        private int[] valueArray;
        private int indexMax;
        private Random random;
        public RandomizedSet() {
            valueToIndexMap = new HashMap<>();
            valueArray = new int[200010];
            indexMax = -1;
            random = new Random();
        }

        public boolean insert(int val) {
            if(valueToIndexMap.containsKey(val)) {
                return false;
            }
            valueToIndexMap.put(val, ++indexMax);
            valueArray[indexMax] = val;
            return true;
        }

        public boolean remove(int val) {
            if(valueToIndexMap.containsKey(val)) {
                int index = valueToIndexMap.get(val);
                valueToIndexMap.remove(val);
                valueArray[index] = valueArray[indexMax];
                if(index != indexMax) {
                    valueToIndexMap.put(valueArray[indexMax], index);
                }
                indexMax--;
                return true;
            }
            return false;
        }

        public int getRandom() {
            int index = random.nextInt(indexMax + 1);
            return valueArray[index];
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
