package DataStructure.Design;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/24/19
 * Time: 5:51 PM
 * Description:
 *
 * 找规律 O（1） time
 */


public class _348_DesignTicTacToe_Array {
    int[] rows;
    int[] cols;
    int diagonal;
    int anti_diagonal;
    int size;

    /** Initialize your data structure here. */
    public _348_DesignTicTacToe_Array(int n) {
        this.size = n;
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd =  player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;

        if(row == col)
            diagonal += toAdd;

        if (col == (size - row - 1))
            anti_diagonal += toAdd;

        if(Math.abs(rows[row]) == size) return player;
        if(Math.abs(cols[col]) == size) return player;
        if(Math.abs(anti_diagonal) == size ) return player;
        if(Math.abs(diagonal) == size ) return player;

        return 0;
    }


    // solution  brute force
    private int[][] board;
    private int n;

    public void TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public int move_brute(int row, int col, int player) {
        board[row][col] = player;
        // check if the player wins
        if ((checkRow(row, player)) ||
            (checkColumn(col, player)) ||
            (row == col && checkDiagonal(player)) ||
            (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        // No one wins
        return 0;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }
}
