package XianQiao;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS_XianQiao {
    public int countIsland (char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        int nums = 0;
        int[][] dirs = new int[][]{{1, 0}, {1, -1}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    grid[i][j] = '2';
                    Queue<int[]> q = new LinkedList<>();
                    int[] curPosition = new int[]{i, j};
                    q.add(curPosition);

                    while (!q.isEmpty()) {
                        int[] position = q.poll();
                        for (int[] d : dirs) {
                            int nextX = d[0] + position[0];
                            int nextY = d[1] + position[1];
                            if (nextX >= 0 && nextY >= 0 && nextX < grid[0].length
                                    && nextY < grid.length && grid[nextX][nextY] == '1') {
                                int[] nextPosition = new int[]{nextX, nextY};
                                q.add(nextPosition);
                                grid[nextX][nextY] = '2';
                            }

                        }
                    }

                }
            }
            }
        return nums;
    }

}
