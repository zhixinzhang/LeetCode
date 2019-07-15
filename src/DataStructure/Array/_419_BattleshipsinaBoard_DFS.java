package DataStructure.Array;

public class _419_BattleshipsinaBoard_DFS{

	 public int countBattleships_DFS(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        boolean[][] marked = new boolean[M][N];
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X' && !marked[i][j] && dfs(board, i, j, marked)) cnt++; 
            }
        }
        return cnt;
    }
    
    public boolean dfs(char[][] board, int r, int c, boolean[][] marked) {
        marked[r][c] = true;
        int[] direct = {1, 0, -1, 0, 1};
        int cnt = 0;
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            int newR = r + direct[i];
            int newC = c + direct[i + 1];
            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && !marked[newR][newC] && board[newR][newC] == 'X') {
                cnt++;
                if (!dfs(board, newR, newC, marked)) res = false;
            }
        }
        return cnt > 1 || res;
    }



   public int countBattleships(char[][] board) {
        int m = board.length;
        if(m == 0) return 0;
        int n = board[0].length;
        int count = 0;
        for(int i = 0; i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(board[i][j] == '.')continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
            
        }
        return count;
    }

}