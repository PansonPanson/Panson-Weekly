package top.panson.injava.question.top100;

import java.util.Arrays;

/**
 * '
 * 62 不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @create 2022-01-17 18:14
 * @Author: Panson
 */
public class L062 {


    /**
     * 一维的dp数组定义为当前行中，每个元素对应的步数。 二维dp数组dp[i][j] = dp[i-1][j] + dp[i][j-1]很好理解
     * 转化为一维数组，对于第i行来说，dp[j] = dp[j] + dp[j-1], 等号右边的未赋值之前的dp[j]就是上一行的第j个数据对应的步数，
     * 即dp[i-1][j] 等号右边的dp[j-1]是已经更新过的本行的第j-1个数据对应的步数，即dp[i][j-1] 则，
     * 本行的dp[j] = 上一行的dp[j] + 本行的dp[j-1]， 所以dp[j] = dp[j] + dp[j-1]，即dp[j] += dp[j-1].
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }


    /**
     * 粗暴标记
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths0(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }




}
