package top.panson.injava.code.question.enterprise.pdd;

import java.util.*;

/**
 * @author Panson
 * @create 2025-01-23
 */
public class L022 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, String current, int open, int close, int max) {
            // 如果长度达到 2 * n，表示生成完成，加入结果列表
            if (current.length() == max * 2) {
                result.add(current);
                return;
            }

            // 尝试添加左括号
            if (open < max) {
                backtrack(result, current + "(", open + 1, close, max);
            }

            // 尝试添加右括号
            if (close < open) {
                backtrack(result, current + ")", open, close + 1, max);
            }
        }
    }

}
