package top.panson.injava.tags.difarray;

/**
 * @author Panson
 * @create 2024-03-12
 */
public class L1450 {

    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int[] dif = new int[1001];
            int n = startTime.length;
            for(int i = 0; i < n; i++) {
                dif[startTime[i]]++;
                dif[endTime[i] + 1]--;
            }
            int sum = 0;
            for(int i = 0; i < queryTime; i++) {
                sum += dif[i];
            }
            return sum;
        }
    }
}
