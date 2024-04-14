package top.panson.injava.tags.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2024-04-15
 */
public class L052 {
    class Solution {
        int res = 0;
        public int totalNQueens(int n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder stb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    stb.append(".");
                }
                board.add(stb.toString());
            }
            backTrack(board, 0);
            return res;
        }

        public void backTrack(List<String> board, int row) {
            int n = board.get(0).length();
            if (row == board.size()) {
                res++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (!valid(board, row, col)) {
                    continue;
                }
                StringBuilder cur = new StringBuilder(board.get(row));
                cur.setCharAt(col, 'Q');
                board.set(row, cur.toString());
                backTrack(board, row + 1);
                cur.setCharAt(col, '.');
                board.set(row, cur.toString());
            }
        }

        public boolean valid(List<String> board, int row, int col) {
            int n = board.size();
            // 检查列是否有皇后互相冲突
            for (int i = 0; i <= row; i++) {
                if (board.get(i).charAt(col) == 'Q')
                    return false;
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }
            return true;
        }

    }
}
