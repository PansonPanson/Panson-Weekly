package top.panson.injava.code.question.enterprise.pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-01-25
 */
public class L093 {

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if(s == null || s.length() < 4 || s.length() > 12) {
                return res;
            }
            backtrack(s, 0, new ArrayList<>(), res);
            return res;
        }

        public void backtrack(String s, int start, List<String> ipSegments, List<String> res) {
            if(ipSegments.size() == 4) {
                if(start == s.length()) {
                    res.add(String.join(".", ipSegments));
                }
                return;
            }

            for(int len = 1; len <= 3; len++) {
                if(start + len > s.length()) {
                    break;
                }
                String segment = s.substring(start, start + len);

                if(isValid(segment)) {
                    ipSegments.add(segment);
                    backtrack(s, start + len, ipSegments, res);
                    ipSegments.remove(ipSegments.size() - 1);
                }
            }

        }

        public boolean isValid(String segment) {
            if(segment.length() > 1 && segment.charAt(0) == '0') {
                return false;
            }
            int val = Integer.parseInt(segment);
            return val >= 0 && val <= 255;
        }

    }
}
