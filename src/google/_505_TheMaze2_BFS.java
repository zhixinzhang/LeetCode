package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/25.
 * 有bug 看另一个
 */
public class _505_TheMaze2_BFS {
   static class ball{
        int x;
        int y;
        int l;
        public ball(int x, int y, int l){
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0)    return -1;
        if(start == destination)    return 0;
        int res = Integer.MAX_VALUE;
        Queue<ball> q = new LinkedList<>();
        q.add(new ball(start[0],start[1],0));       // initial start position
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                ball curBall = q.poll();
                // find next position
                for(int[] dir : directions){
                    ball nextBall = find(curBall,dir,maze);
                    // we find the end position
                    if(nextBall.x == destination[0] && nextBall.y == destination[1]){
                        res = Math.min(res,nextBall.l);
                    }
                    if(nextBall.l >= res)
                        continue;
                    q.add(nextBall);
                }
            }
        }
        return res == -1 ? -1 : res;
    }
    private static ball find(ball curBall, int[] dir, int[][] maze){
        int l = curBall.l;
        int x = curBall.x;
        int y = curBall.y;
        while(x < 0 || x > maze.length || y<0 || y>maze[0].length){
            x = x + dir[0];
            y = y + dir[1];
            l++;
        }
        return new ball(x,y,l);
    }
    public static void main(String[] args){
        shortestDistance(new int[][]{{0,0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}},new int[]{0,4}, new int[]{4,4});

    }
}
