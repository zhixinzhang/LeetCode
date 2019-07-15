package google;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/5/21.
 * 重点是 这个2D的数组里 每个值是他的海拔 每一秒都下雨
 * 当海拔跟四周相等之后 才可以游过去
 * 要求 求出最少多少秒才可以 游到右下角
 0  1  2  3  4
 24 23 22 21  5
 12 13 14 15 16
 11 17 18 19 20
 10  9  8  7  6
 维护一个priorityqueue 每次最小的高度 同时维持当前最大的值
 */
// O(n^2 logn)
public class _778_SwiminRisingWater_DFS {
    public int swimInWater_PQ(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[]{0, 0});
        int level = 0;
        int n = grid.length;
        int[][] nexts = {{0 ,1}, {0, -1},{1, 0}, {-1, 0}};
        boolean[][] isVisited = new boolean[n ][n];
        while (!pq.isEmpty()){
            int[] top = pq.poll();
            level = Math.max(level, grid[top[0]][top[1]]);
            if (top[0] == n - 1 && top[1] == n - 1){
                break;
            }

            for (int[] next : nexts){
                int x = top[0] + next[0];
                int y = top[1] + next[1];
                if (!(x < 0|| x > n - 1 || y < 0 || y > n - 1)  && !isVisited[x][y]){
                    isVisited[top[0]][top[1]] = true;
                    pq.add(new int[]{x, y});
                }
            }
        }
        return level;
    }



    public static int swimInWater(int[][] grid) {
        if (grid == null || grid[0].length == 0)    return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = grid[row-1][col-1] - grid[0][0];
        HashSet<int[]> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[]{0,0});
        visited.add(new int[]{0,0});
        // 0  (1,23)
        while (!pq.isEmpty()){
            int[] curPoint = pq.poll();
            int curPointRow = curPoint[0];
            int curPointCol = curPoint[1];
            int val = grid[curPointRow][curPointCol];
            res = Math.max(res,val);
            int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] d : dir){
                int nextPointRow = curPoint[0] + d[0];
                int nextPointCol = curPoint[1] + d[1];
                // out of border
                if (nextPointRow < 0 || nextPointRow > grid.length || nextPointCol <0 || nextPointCol > grid[0].length)
                    continue;
                if (visited.contains(new int[]{nextPointRow,nextPointCol})){
                    continue;
                }
                int nextPointVal =  grid[nextPointRow][nextPointCol];
                if (nextPointCol == grid.length -1 && nextPointRow == grid[0].length -1)
                    return  Math.max(nextPointVal,res) - grid[0][0];
//                if (nextPointVal > res){
                pq.add(new int[]{nextPointRow,nextPointCol});
//                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] grid = new int[][]{{0,2},{1,3}};
        swimInWater(grid);
    }
}
