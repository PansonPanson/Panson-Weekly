package top.panson.injava.question.practice.array;

/**
 * @create 2022-08-19 10:24
 * @Author: Panson
 */
public class L1450 {

    class Solution {

        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int res = 0;
            for(int i = 0; i < startTime.length; i++) {
                if(queryTime >= startTime[i] && queryTime < endTime[i]) {
                    res++;
                }
            }
            return res;
        }
    }
}
