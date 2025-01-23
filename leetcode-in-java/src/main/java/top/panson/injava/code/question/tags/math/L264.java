package top.panson.injava.code.question.tags.math;

/**
 * @author Panson
 * @create 2024-07-01
 */
public class L264 {

    class Solution {
        public int nthUglyNumber(int n) {
            int i = 1;
            int[] ugly = new int[n + 1];
            int p1 = 1;
            int p2 = 1;
            int p3 = 1;
            int step2 = 1;
            int step3 = 1;
            int step5 = 1;

            while(i <= n) {
                int min = Math.min(Math.min(step2, step3), step5);
                ugly[i] = min;
                i++;
                if(min == step2) {
                    step2 =  2 * ugly[p1++];
                }
                if(min == step3) {
                    step3 = 3 * ugly[p2++];
                }
                if(min == step5) {
                    step5 = 5 * ugly[p3++];
                }
            }
            return ugly[n];
        }
    }
}
