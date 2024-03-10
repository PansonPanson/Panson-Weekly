package top.panson.injava.tags.difarray;

/**
 * @author Panson
 * @create 2024-03-10
 */
public class L1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] dif = new int[n + 1];
            for(int[] booking : bookings) {
                int l = booking[0] - 1;
                int r = booking[1] - 1;
                dif[l] += booking[2];
                dif[r + 1] -= booking[2];
            }

            int[] ret = new int[n];
            ret[0] = dif[0];
            for(int i = 1; i < n; i ++) {
                ret[i] = ret[i - 1] + dif[i];
            }
            return ret;
        }
    }
}
