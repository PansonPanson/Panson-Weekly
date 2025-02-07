package top.panson.injava.code.question.classic150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-02-07
 */
public class L412 {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                boolean a = i % 3 == 0;
                boolean b = i % 5 == 0;
                if(a && b) {
                    res.add("FizzBuzz");
                } else if(a) {
                    res.add("Fizz");
                } else if(b) {
                    res.add("Buzz");
                } else {
                    res.add(i + "");
                }
            }
            return res;
        }
    }
}
