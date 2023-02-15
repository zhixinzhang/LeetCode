package DataStructure.Array;
import java.util.*;

/**
 * Created by zhang on 2018/5/8.
 * 区别于普通的 dfs bfs 只有遇到dege 或者 墙才会停下来
 * 需要做个判断
 */
public class _490_TheMaze_DFS_BFS {
    int [][] dirs= new int [][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        return dfs(maze, start, destination, visited, rows, cols);  
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination,boolean[][] visited,int rows,int cols){
       if(visited[start[0]][start[1]])  return false;
        
        if(start[0]==destination[0]&& start[1]==destination[1]) return true;
        visited[start[0]][start[1]]=true;
        
        for(int [] dir:dirs){
            int dx= start[0];
            int dy= start[1];
            while(dx+dir[0]>=0&&dx+dir[0]<rows&&dy+dir[1]>=0&&dy+dir[1]<cols&&maze[dx+dir[0]][dy+dir[1]]!=1){
                dx+=dir[0];
                dy+=dir[1];
            }
            if(dfs(maze,new int[]{dx,dy},destination,visited,rows,cols)){
                return true;
            }
        }
        return false;
    }


    int[][] move = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);

        while (!queue.isEmpty()) {
          int[] cur = queue.poll();
          if (cur[0] == destination[0] && cur[1] == destination[1]) {
            return true;
          }
          if (visited[cur[0]][cur[1]])
            continue;
          visited[cur[0]][cur[1]] = true;
          
          for (int[] mo : move) {
            int x = cur[0], y = cur[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
              x += mo[0];
              y += mo[1];
            }
            // Back to validate point.
            x -= mo[0];
            y -= mo[1];
            // Adding new start point.
            queue.offer(new int[] {x, y});
          }
        }
        return false;
      }
}
