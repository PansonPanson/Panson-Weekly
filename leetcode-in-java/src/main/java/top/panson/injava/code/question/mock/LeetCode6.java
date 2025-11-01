package top.panson.injava.code.question.mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-11-01
 */
public class LeetCode6 {

    class Solution {
        public String convert(String s, int numRows) {
            // 模拟题
            if(numRows < 2) {
                return s;
            }
            List<StringBuilder> tmp = new ArrayList<>();
            for(int i = 0; i < numRows; i++) {
                tmp.add(new StringBuilder());
            }
            int i = 0;
            int dir = -1;
            for(char ch : s.toCharArray()) {
                tmp.get(i).append(ch);
                if(i == 0 || i == numRows - 1) {
                    dir = -dir;
                }
                i += dir;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder stb : tmp) {
                res.append(stb);
            }
            return res.toString();
        }
    }
}
