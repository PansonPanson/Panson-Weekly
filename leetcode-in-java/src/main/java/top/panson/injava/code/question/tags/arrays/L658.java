package top.panson.injava.code.question.tags.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-02-19
 */
public class L658 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;
            while(right - left >= k) {
                if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    left++;
                } else {
                    right--;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                result.add(arr[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
