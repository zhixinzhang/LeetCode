package company.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/23/19
 * Time: 1:50 PM
 * Description:
 */


public class _994_RottingOranges_BFS {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        boolean[][] cache = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;      //fresh orange
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; i++){
                if (grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    cache[i][j] = false;
                }else if (grid[i][j] == 0)
                    cache[i][j] = true;
                else
                    count++;
            }
        }
        int level = 0;
        int[][] directs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while (q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] curPoint = q.poll();
                int x = curPoint[0], y = curPoint[1];
                // four direction
                for (int[] d : directs){
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if (nextX >= 0 && nextX <= grid.length-1 && nextY >= 0 && nextY <= grid[0].length){
                        if (cache[nextX][nextY] == false){
                            q.add(new int[]{nextX, nextY});
                            count--;
                        }
                    }
                }
            }
            level++;
        }
        return count == 0 ? level : -1;

    }
}
