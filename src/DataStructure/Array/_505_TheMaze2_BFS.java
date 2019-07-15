package DataStructure.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/5/8.
 * 跟 Maze一样 只是要找最短路径长度
 * 定义一个class 类，然后要记住到当前的跑了多少距离
 *
 */
public class _505_TheMaze2_BFS {
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
        Queue<Point> queue = new LinkedList<Point>();
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
}
