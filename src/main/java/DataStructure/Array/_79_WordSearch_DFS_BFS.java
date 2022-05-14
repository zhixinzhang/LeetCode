package DataStructure.Array;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 *
 * Time Complexity: \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
 * L
 *  ) where NN is the number of cells in the board and LL is the length of the word to be matched.
 *
 * For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L3
 * L
 *  .
 *
 * We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
 *
 * As a result, overall the time complexity of the algorithm would be \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
 * L
 *  ).
 *
 * Space Complexity: \mathcal{O}(L)O(L) where LL is the length of the word to be matched.
 *
 * The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is \mathcal{O}(L)O(L).
 * Key Point:
 */

public class _79_WordSearch_DFS_BFS {

    int[][] directions = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return true;
        }

        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == wordChar[0]) {
                    if(dfs(board, i, j, visited, 1, wordChar)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs (char[][] board, int curRow, int curCol, boolean[][] visited, int index, char[] wordChar){
        if (index == wordChar.length) {
            return true;
        }
        if (visited[curRow][curCol]){
            return false;
        }
        visited[curRow][curCol] = true;

        for (int[] dir : directions){
            int nextRow = curRow + dir[0];
            int nextCol = curCol + dir[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length &&
                    !visited[nextRow][nextCol] && wordChar[index] == board[nextRow][nextCol]) {
                if (dfs(board, nextRow, nextCol, visited, index + 1, wordChar)){
                    return true;
                }
            }
        }

        visited[curRow][curCol] = false;
        return false;

    }
}
