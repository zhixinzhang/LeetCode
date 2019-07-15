package company.uber;


/**
 * Created by zhang on 2018/9/9.
 */
public class _79_WordSearch_DFS_BFS {
    // bfs 很难做  还是用dfs
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (visited[i][j] || word.charAt(0) != board[i][j])
                    continue;
                visited[i][j] = true;
                if (dfs(board,word,1,i,j))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word,int idx,int i, int j){
        if (idx == word.length())
            return true;
        for (int[] d : dirs){
            int nextI = i + d[0];
            int nextJ = j + d[1];
            if (nextI < 0 || nextJ < 0 || nextI >= board.length || nextJ >= board[0].length || visited[nextI][nextJ])
                continue;
            if (board[nextI][nextJ] == word.charAt(idx))
                if (dfs(board,word,idx+1,nextI,nextJ))
                    return true;
        }
        return false;
    }

    public boolean exist_another(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int n, int i, int j) {
        if (n == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j])
            return false;
        if (word.charAt(n) != board[i][j])
            return false;
        visited[i][j] = true;
        boolean result = search(board, word, n + 1, i - 1, j) || search(board, word, n + 1, i + 1, j) || search(board, word, n + 1, i, j - 1) || search(board, word, n + 1, i, j + 1);
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args){
//        char[][] board = new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'},
//                {'L','M','H','G'},
//                {'C','D','E','E'}
//        };
        char[][] board = new char[][]{
                {'A','A'},
        };
        long a = System.nanoTime();
        System.out.println("start time  :" + a);
        boolean res = exist(board, "AAA");
        long b = System.nanoTime();
        System.out.println("end time  :" + b);
        System.out.println("reduce  :" +  (long)(b - a));
    }
}
