package top.panson.injava.question.practice.array;

/**
 * @create 2022-06-04 00:10
 * @Author: Panson
 */
public class L1109 {

    class Solution {
        int[] dif;
        public int[] corpFlightBookings(int[][] bookings, int n) {
            dif = new int[n];
            int[] res = new int[n];

            for(int[] arr : bookings) {
                dif[arr[0] - 1] += arr[2];
                if(arr[1] < n) {
                    dif[arr[1]] -= arr[2];
                }

            }
            res[0] = dif[0];
            for(int i = 1; i < n; i++) {
                res[i] = res[i - 1] + dif[i];
            }
            return res;
        }
    }
}
