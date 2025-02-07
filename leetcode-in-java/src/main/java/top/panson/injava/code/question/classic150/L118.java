package top.panson.injava.code.question.classic150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();

            for(int i = 0; i < numRows; i++) {
                List<Integer> cur = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        cur.add(1);
                    } else {
                        cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
                res.add(cur);
            }
            return res;
        }
    }
}
