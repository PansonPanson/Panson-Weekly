package top.panson.injava.code.question.tags.presum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-07-25
 */
public class Lcr180 {

    class Solution {
        public int[][] fileCombination(int target) {
            if(target < 3) {
                return new int[0][];
            }
            int i = 1;
            int j = 1;
            int sum = 0;
            List<int[]> res = new ArrayList<>();
            // 123  3
            while(i <= target / 2) {
                if(sum < target) {
                    sum += j;
                    j++;
                } else if(sum > target) {
                    sum -= i;
                    i++;
                } else {
                    int[] subRes = new int[j - i];
                    for(int k = i; k < j; k++) {
                        subRes[k - i] = k;
                    }
                    res.add(subRes);
                    sum -= i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
