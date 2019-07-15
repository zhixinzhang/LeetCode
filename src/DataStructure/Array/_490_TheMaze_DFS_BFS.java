package DataStructure.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/5/8.
 * 区别于普通的 dfs bfs 只有遇到dege 或者 墙才会停下来
 * 需要做个判断
 */
public class _490_TheMaze_DFS_BFS {
    public static void main(String[] args){
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
//        maze_DFS(maze,new int[]{4,4},new int[]{4,4});
    }

    public boolean maze_DFS(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0 || maze[0].length == 0) return false;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        m = maze.length; n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, destination, visited);
    }
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean dfs(int[][] maze, int[] cur, int[] dest, boolean[][] visited) {
        // already visited
        if(visited[cur[0]][cur[1]]) return false;
        // reach destination
        if(Arrays.equals(cur, dest)) return true;

        visited[cur[0]][cur[1]] = true;
        for(int[] dir : dirs) {
            int nx = cur[0], ny = cur[1];
            while(notWall(nx + dir[0], ny + dir[1]) && maze[nx+dir[0]][ny+dir[1]] != 1) {
                nx += dir[0]; ny += dir[1];
            }
            if(dfs(maze, new int[] {nx, ny}, dest, visited)) return true;
        }
        return false;
    }

    private boolean notWall(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }



    public static int[] goStop(int[][] maze, int[] start, int[] d){
        while ((start[0] + d[0] < maze.length) && (start[1] + d[1] <maze[0].length)){
            if (maze[start[0] + d[0]][start[1] + d[1]] != 1){
                start[0] = start[0] + d[0];
                start[1] = start[1] + d[1];
            }else{
                return start;
            }
        }
        return start;
    }


    public static boolean maze_BFS(int[][] maze, int[] start, int[] end){
        if (start[0] == end[0] && start[1] == end[1])   return true;
        if (maze == null || maze.length == 0 || maze[0].length == 0)    return false;
        Queue<int[]> q = new LinkedList<>();
        int r = maze.length, c = maze[0].length;
        boolean[][] visited = new boolean[r][c];
        q.add(start);
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()){
            int curSize = q.size();
            for (;curSize >= 0; curSize--){
                int[] curNode = q.poll();
                for (int[] d : directions){
                    int[] nextNode = goStop(maze,curNode,d);
                    if (nextNode[0] == end[0] && nextNode[1] == end[1])
                        return true;
                    if (visited[nextNode[0]][nextNode[1]]) {
                        visited[nextNode[0]][nextNode[1]] = true;
                        q.add(nextNode);
                    }
                }
            }
        }
        return false;
    }
}
