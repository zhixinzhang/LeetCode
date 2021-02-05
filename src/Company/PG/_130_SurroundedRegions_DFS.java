package Company.PG;

/**
 * Created by zhang on 2018/1/27.
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 */

/**solution :
 * 遍历四个边 找到 O 那么所有和O链接的O 都不能被改成X
 * time O(m * n) space O(n)
 * */
public class _130_SurroundedRegions_DFS {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;
        // find 4 edges
        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n] == 'O') {
                dfs(board, i, n);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m][i] == 'O') {
                dfs(board, m, i);
            }
        }
        // for loop again and change "O" --- "X"
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
