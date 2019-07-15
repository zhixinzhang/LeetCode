package DataStructure.Array;

/**
 * Created by zhang on 2017/10/
 * Given a 2D board and a word, find if the word exists in the grid.
 */
/** 用dfs 进行recusrion 上下左右
 * 并且重点要判断之前的点是否搜索过 同时判断边界是否满足条件
 * */
public class _79_WordSearch_DFS {
    int[][] dire = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
            return true;
        int row = board.length, col = board[0].length;
        boolean[][] cache = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                char c = word.charAt(0);
                if(board[i][j] == c){
                    if(dfs(1,word,i,j,board,cache))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int idx, String word, int i, int j, char[][] board, boolean[][] cache){
        if(idx == word.length())
            return true;
        if(cache[i][j])
            return false;
        cache[i][j] = true;

        for(int[] d : dire){
            int nx = d[0] + i;
            int ny = d[1] + j;
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !cache[nx][ny] && word.charAt(idx) == board[nx][ny])
                if(dfs(idx + 1, word, nx, ny, board, cache))
                    return true;
        }
        cache[i][j] = false;
        return false;
    }


//    public static void main(String[] args){
//        char[][] board = new char[3][4];
//        board[0] = new char[] {'A','B','C','E'};
//        board[1] = new char[] {'S','F','C','S'};
//        board[2] = new char[] {'A','D','E','E'};
//        String word = "ABCESSE";
//        boolean a = exist(board,word);
//        int c = 0;
//    }



//    class Solution {
//        boolean[][] visited;
//        public boolean exist(char[][] board, String word) {
//            if (word.length() == 0)
//                return true;
//            int m = board.length;
//            int n = board[0].length;
//            visited = new boolean[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (search(board, word, 0, i, j))
//                        return true;
//                }
//            }
//            return false;
//        }
//
//        private boolean search(char[][] board, String word, int n, int i, int j) {
//            if (n == word.length())
//                return true;
//            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
//                return false;
//            if (visited[i][j])
//                return false;
//            if (word.charAt(n) != board[i][j])
//                return false;
//            visited[i][j] = true;
//            boolean result = search(board, word, n + 1, i - 1, j) || search(board, word, n + 1, i + 1, j) || search(board, word, n + 1, i, j - 1) || search(board, word, n + 1, i, j + 1);
//            visited[i][j] = false;
//            return result;
//        }
//    }
}
