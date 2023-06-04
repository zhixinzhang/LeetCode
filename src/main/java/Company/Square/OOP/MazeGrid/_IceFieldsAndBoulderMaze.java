package Company.Square.OOP.MazeGrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LC : 490 
public class _IceFieldsAndBoulderMaze {
    public static void main(String[] args) {
        int[] start = new int[]{1, 0};
        // int[] end = new int[]{8, 4};
        int[] end = new int[]{3, 11};
        String[][] grid = buildGrid(10, 12, start, end);
        List<int[]> ans = findAllMoves(grid, start);
        boolean ans2 = canAReachB(grid, start, end);
        System.out.println(ans2);
    }

    private static String[][] buildGrid(int col, int row, int[] start, int[] end){
        String[][] grid = new String[col][row];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                grid[i][j] = "*";
            }
        }

        grid[5][2] = "#";
        grid[6][3] = "#";
        grid[9][4] = "#";
        grid[9][6] = "#";
        grid[1][8] = "#";
        grid[1][10] = "#";
        grid[7][10] = "#";
        grid[3][11] = "#";
        grid[4][11] = "#";
        grid[start[0]][start[1]] = "A";
        grid[end[0]][end[1]] = "E";

        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        return grid;
    }

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static List<int[]> findAllMoves(String[][] grid, int[] start){
        int col = grid.length;
        int row = grid[0].length;
        List<int[]> ans = new ArrayList<>();
        
        a : for (int[] dir : dirs){
            
            int nextX = start[0] + dir[0];
            int nextY = start[1] + dir[1];
            while(nextX >= 0 && nextX < col && nextY >= 0 && nextY < row){
                if (grid[nextX][nextY] == "#") {
                    break;
                }
                // if (grid[nextX][nextY] == "E") {
                //     ans.add(new int[]{preX, preY});
                //     break a;
                // }
                nextX = nextX + dir[0];
                nextY = nextY + dir[1];
            }
            int preX = nextX - dir[0];
            int preY= nextY - dir[1];

            if (preX != start[0] || preY != start[1]) {
                ans.add(new int[]{preX, preY});
                System.out.println(String.valueOf(preX) + " , " + String.valueOf(preY));
            }
        }

        return ans;
    }   

    static Set<String> allPoints = new HashSet<>();
    private static boolean canAReachB(String[][] grid, int[] start, int[] end){
        allPoints.add(String.valueOf(start[0]) + ","+String.valueOf(start[1]));
        boolean ans = false;
        // for 
        List<int[]> allPos = findAllMoves(grid, start);
        for (int[] p : allPos){
            String pos = String.valueOf(p[0]) + ","+String.valueOf(p[1]);
            if (p[0] == end[0] && p[1] == end[1]) {
                return true;
            }
            if (allPoints.contains(pos))
                continue;
            allPoints.add(pos);
            boolean curAns = canAReachB(grid, p, end);
            if (curAns) {
                return true;
            }
        }
        
        return ans;
    }

}
