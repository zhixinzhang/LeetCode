package Company.Square;

import java.util.Random;

// https://www.1point3acres.com/bbs/thread-920981-1-1.html
/**
 * 写一个扫雷，m * n 的排布，问题1：你会用什么数据结构表示
问题2：构建一个平面grid，里面有随机放置埋好的雷
问题3：写一个方法展示出所有雷的位置
Follow up 1: 对于非雷格子，计算并展示出附件雷的数量，也就是把完整的扫雷平面展示出来
grid‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌大小应该可以自己定义，要求提前run，尽快跑出正确结果，一开始和最后会有一点点的bq
 * */ 
public class _Minesweeper_Design {
    public static void main(String[] args) {
        int mCount = 5;
        String[][] grid = buildGrid(6, 6, mCount);

        System.out.println("outputing mine grid");
        printGrid(grid);
        // Follow up 1: 对于非雷格子，计算并展示出附件雷的数量，也就是把完整的扫雷平面展示出来
        
        System.out.println("outputing new mine grid");
        grid = showMineCount(grid);

        printGrid(grid);
    }

    private static String[][] buildGrid(int col, int row, int mCount){
        String[][] grid = new String[row][col];
        Random random = new Random();
        for (int i = 0; i < mCount; i++){
            int x = random.nextInt(5);
            int y = random.nextInt(5);
            grid[x][y] = "m";
        }
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] != "m") {
                    grid[i][j] = "0";
                }
            }
        }

        return grid;
    }

    private static void printGrid(String[][] grid){
        for (int i = 0; i < grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++){
                sb.append(grid[i][j]);
            }

            System.out.println(sb.toString());
        }

    }

    private static String[][] showMineCount(String[][] grid){
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == "m" || grid[i][j] != "0") {
                    continue;
                }

                int count = 0;
                for (int[] dir : dirs){
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];
                    if (nextX >=0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && grid[nextX][nextY] == "m"){
                        count ++;
                    }
                }

                grid[i][j] = String.valueOf(count);
            }
        }

        return grid;

    }
}
