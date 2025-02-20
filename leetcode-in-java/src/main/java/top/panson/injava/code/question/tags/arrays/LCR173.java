package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-02-20
 */
public class LCR173 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeAttendance(int[] records) {
            int left = 0;
            int right = records.length;
            // 0 1 2 4 5
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(records[mid] == mid) {
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
