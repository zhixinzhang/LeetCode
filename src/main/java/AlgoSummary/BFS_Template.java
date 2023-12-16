package AlgoSummary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/19/19
 * Time: 3:22 PM
 * Description:
 * based on leetcode 200
 */


public class BFS_Template {
    int[][] dir = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
//        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dir){
                int nextX = cur[0] + d[0];
                int nextY = cur[1] + d[1];
                if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length)
                    if(grid[nextX][nextY] == '1'){
                        q.add(new int[]{nextX, nextY});
                        grid[nextX][nextY] = '2';
                    }
            }
        }
        return;
    }
}
