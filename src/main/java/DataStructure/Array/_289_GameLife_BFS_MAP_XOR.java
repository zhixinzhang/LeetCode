package DataStructure.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 2:11 PM
 * Description:
 */


public class _289_GameLife_BFS_MAP_XOR {
    // if 0 -> 1: 2
    // if 1 -> 0: 3
    // 0 -> 0
    // 1 -> 1
    // 2 -> 0
    // 3 -> 1
    Map<Integer, Integer> map = new HashMap<>();
    public void gameOfLife(int[][] board) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 0);
        map.put(3, 1);

        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isLive(board, i, j)) {
                    int val = 1;
                    if (board[i][j] == 0) val = 2;
                    board[i][j] = val;
                } else {
                    int val = 0;
                    if (board[i][j] == 1) val = 3;
                    board[i][j] = val;
                }
            }
        }

        // move back to original value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 2 -> 1
                // 3 -> 0
                if (board[i][j] > 1) {
                    if (board[i][j] == 2) board[i][j] = 1;
                    else board[i][j] = 0;
                }
            }
        }
    }

    private boolean isLive(int[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        int[] dx = {1,-1,0,0, 1,1,-1,-1};
        int[] dy = {0,0,1,-1, 1,-1,1,-1};
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
            int val = map.get(board[x1][y1]);
            if (val == 1) count++;
        }
        int curr = map.get(board[x][y]);
        if (curr == 0 && count == 3) return true;
        if (curr == 1 && count < 2) return false;
        if (curr == 1 && count <= 3) return true;
        if (curr == 1 && count > 3) return false;
        return false;
    }
}
