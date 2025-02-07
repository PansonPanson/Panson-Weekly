package top.panson.injava.code.question.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            for(int cur : nums1) {
                map1.put(cur, map1.getOrDefault(cur, 0) + 1);
            }
            for(int cur : nums2) {
                map2.put(cur, map2.getOrDefault(cur, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                if(map2.containsKey(entry.getKey())) {
                    int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                    for(int i = 0; i < count; i++) {
                        res.add(entry.getKey());
                    }
                }
            }
            return res.stream().mapToInt(i -> i).toArray();

        }
    }
}
