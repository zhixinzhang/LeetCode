package google.Graph;

/**
 * Created by zhang on 2018/6/13.
 * 白人seti小哥 气氛很欢快，聊的蛮开心。  下围棋， 判断棋盘上一个点是不是被包围了。
 用了dfs 写的挺顺的。 然后问testcase， 画了各种形状的围棋图， 小哥觉得形状挺有意思的。 然后五分钟又是聊， 问了问seti都做什么
 */
public class GOSurround_DFS {
    public boolean surround(char[][] go,int[] pos){
        if (go == null || go.length == 0)
            return false;
        // enemy is 'x'  my 'o'
        if (go[pos[0]][pos[1]] == 'o')  return false;
        boolean[][] visited = new boolean[go.length][go[0].length];
        return dfs(go,pos,visited);
    }
    public boolean dfs(char[][] go, int[] pos, boolean[][] visited){
        int row = go.length;
        int col = go[0].length;
        if (visited[pos[0]][pos[1]])
            return false;
        visited[pos[0]][pos[1]] = true;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : dirs){
            int nextX = pos[0] + dir[0];
            int nextY = pos[1] + dir[1];
            if (nextX > row || nextX < 0 || nextY > col || nextY < 0)
                continue;
            int[] nextPos = new int[]{nextX,nextY};
            if (go[nextX][nextY] != 'x' && !visited[nextX][nextY])
                if(dfs(go,nextPos,visited))
                    return true;
        }
        return false;
    }
}
