package top.panson.injava.code.question.tags.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-02-19
 */
public class L792 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            // 预处理
            Map<Character, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                List<Integer> list =  map.getOrDefault(c, new ArrayList<Integer>());
                list.add(i);
                map.put(c, list);
            }
            int count = 0;
            for(String word : words) {
                if(isSubseq(s, word, map)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isSubseq(String s, String word, Map<Character, List<Integer>> map) {
            int i = 0;
            for(int j = 0; j < word.length(); j++) {
                // s 中对应字符的下标列表
                List<Integer> list = map.get(word.charAt(j));
                if(list == null) {
                    return false;
                }
                // 二分搜索大于等于 i 的最小索引
                // 即在 s[i..] 中搜索等于 word[j] 的最小索引
                int leftBound = getLeftBound(list, i);
                if(leftBound == list.size()) {
                    return false;
                }
                i = map.get(word.charAt(j)).get(leftBound);
                i++;
            }
            return true;
        }

        private int getLeftBound(List<Integer> list, int targetIndex) {
            int left = 0;
            int right = list.size();
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(list.get(mid) == targetIndex) {
                    right = mid;
                } else if(list.get(mid) < targetIndex) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
