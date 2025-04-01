package top.panson.injava.code.question.tags.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-04-01
 */
public class L93 {
    //    25525511135

// 每一层都选择 1 到 3 个字符，

//          2  25 255

// 5 55 552


    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            if(s == null || s.length() < 4 || s.length() > 12) {
                return res;
            }
            traverse(s, new ArrayList<>(), 0);
            return res;
        }

        void traverse(String s, List<String> path, int start) {
            // 字符串已经分割成 4 份了，无论到不到终点，都必须返回，同时如果到了终点，则说明是有效分割
            if(path.size() == 4) {
                // 有效路径才加进去，此处只需判断是否到达字符串终点
                if(start == s.length()) {
                    res.add(String.join(".", path));
                }
                return;
            }

            // 每一层都选择 1 到 3 个字符, IP 地址片段长度只能是 1 到 3
            for(int i = 1; i <= 3; i++) {
                if(start + i > s.length()) {
                    break;
                }

                String segment = s.substring(start, start + i);
                if(isValid(segment)) {
                    path.add(segment);
                    traverse(s, path, start + i);
                    path.remove(path.size() - 1);
                }
            }
        }

        boolean isValid(String s) {
            if(s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        }
    }
}
