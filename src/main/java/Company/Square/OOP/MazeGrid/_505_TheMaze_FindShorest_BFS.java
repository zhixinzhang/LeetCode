package Company.Square.OOP.MazeGrid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _505_TheMaze_FindShorest_BFS {
    class Point {
        int x;
        int y;
        int l;
        public Point(int _x, int _y, int _l) {
            x = _x; y = _y; l = _l;
        }
    }
    public int maze_DFS(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] length = new int[m][n];
        for (int i = 0; i < m; i ++) {
            Arrays.fill(length[i], Integer.MAX_VALUE);
        }
        Queue<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(start[0], start[1], 0));
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            
            Point p = queue.poll();
            for (int[] dir: dirs) {
                int xx = p.x, yy = p.y, ll = p.l;
                while (xx >= 0 && yy >= 0 && xx < m && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                    ll ++;
                }
                xx -= dir[0];
                yy -= dir[1];
                ll --;
                if (ll > length[destination[0]][destination[1]]) {
                    continue;
                }
                if (ll < length[xx][yy]) {
                    length[xx][yy] = ll;
                    queue.offer(new Point(xx, yy, ll));
                }
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE? -1: length[destination[0]][destination[1]];
    }



    // 有点小bug，不是全局最优
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || destination == null) {
            return -1;
        }

        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return bfs(maze, row, col, start, destination, visited);
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int bfs(int[][] maze, int rows, int cols, int[] start, int[] destination,boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int level = queue.size();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < level; i++){
                int[] curPos = queue.poll();   // 0, 4, 0

                for (int[] dir : dirs){
                    int dx = curPos[0];
                    int dy = curPos[1];
                    int count = 0;
                    while(dx+dir[0] >= 0 && dx+dir[0] < rows && dy+dir[1] >=0 && dy+dir[1] < cols
                    && maze[dx+dir[0]][dy+dir[1]] !=1){
                        dx += dir[0];
                        dy += dir[1];
                        count ++;
                    }
                    if (dx == destination[0] && dy == destination[1]) {
                        ans = Math.min(ans, count + curPos[2]);
                    }
                    if (!visited[dx][dy]) {
                        queue.add(new int[]{dx, dy, count + curPos[2]});
                        visited[dx][dy] = true;
                    }
                    
                }
            }

            if (ans != Integer.MAX_VALUE) {
                return ans;
            }

        }


        return -1;
    }
}
