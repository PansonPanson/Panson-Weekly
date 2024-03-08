package top.panson.injava.question.practice.array;

/**
 * @create 2022-09-06 13:36
 * @Author: Panson
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class L828 {
    class Solution {
        public int uniqueLetterString(String s) {

            Map<Character, List<Integer>> index = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!index.containsKey(c)) {
                    index.put(c, new ArrayList<>());
                    index.get(c).add(-1);
                }
                index.get(c).add(i);
            }
            int res = 0;
            for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
                List<Integer> arr = entry.getValue();
                arr.add(s.length());
                for (int i = 1; i < arr.size() - 1; i++) {
                    res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
                }
            }
            return res;
        }
    }

}
