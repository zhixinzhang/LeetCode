package Company.Square.OOP.MazeGrid;
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
        
        // return dfs(maze, start, destination, visited, rows, cols);  
        return hasPathBFS(maze, start, destination, visited, rows, cols);
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

    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination,boolean[][] visited, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
          int[] cur = queue.poll();
          if (cur[0] == destination[0] && cur[1] == destination[1]) {
            return true;
          }
          if (visited[cur[0]][cur[1]])
            continue;
          visited[cur[0]][cur[1]] = true;
          
          for (int[] dir : dirs) {
            int dx= cur[0];
            int dy= cur[1];
            while(dx+dir[0]>=0&&dx+dir[0]<rows&&dy+dir[1]>=0&&dy+dir[1]<cols&&maze[dx+dir[0]][dy+dir[1]]!=1){
                dx+=dir[0];
                dy+=dir[1];
            }
            // Adding new start point.
            if (dx == destination[0] && dy == destination[1]) {
              return true;
            }
            queue.offer(new int[] {dx, dy});
          }
        }

        return false;
      }
}
