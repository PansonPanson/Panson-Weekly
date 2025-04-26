package top.panson.injava.code.question.tags.arrays;

/**
 * @author Panson
 * @create 2025-04-26
 */
public class LCR139 {

    class Solution {
        public int[] trainingPlan(int[] actions) {
            // 指向待处理偶数
            int i = 0;
            int n = actions.length;
            for(int j = 0; j < n; j++) {
                if(actions[j] % 2 == 1) {
                    int tmp = actions[i];
                    actions[i] = actions[j];
                    actions[j] = tmp;
                    i++;
                }
            }
            return actions;

        }
    }
}
