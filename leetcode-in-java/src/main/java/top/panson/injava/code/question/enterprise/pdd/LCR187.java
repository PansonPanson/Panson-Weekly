package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayList;

/**
 * @author Panson
 * @create 2025-01-20
 */
public class LCR187 {
    class Solution {
        public int iceBreakingGame(int num, int target) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < num; i++) {
                list.add(i);
            }
            int index = 0;
            while(num > 1) {
                index = (index + target - 1) % num;
                list.remove(index);
                num--;
            }
            return list.get(0);
        }
    }
}
