package top.panson.injava.code.question.enterprise.pdd;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-01-19
 */
public class LCR186 {
    class Solution {
        public boolean checkDynasty(int[] places) {
            int zeroCount = 0;
            int min = 14;
            int max = -1;
            Set<Integer> valus = new HashSet<>();
            for(int num : places) {
                if(valus.contains(num)) {
                    return false;
                }
                if(num != 0) {
                    valus.add(num);
                }
                if(num != 0) {
                    max = Math.max(num, max);
                    min = Math.min(num, min);
                }
            }

            return (max - min <= 4);
        }
    }
}
