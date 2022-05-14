package Search;

/**
 * Created by zhang on 2017/3/1.
 * [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 *
 */
public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (dfs(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }

        return false;
    }
    public static  boolean dfs(char[][] board,String word,int index,int x,int y,boolean[][] visited){

        if(index == word.length()) return  true; //收斂條件
        return  false;
    }



}
