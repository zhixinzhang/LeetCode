package Company.Square.OOP.MazeGrid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/**
 * https://www.1point3acres.com/bbs/thread-963175-1-1.html
 * 
 * https://www.1point3acres.com/bbs/thread-825957-1-1.html
 * 
 * binaryString = "0010001001100100"
expected output:
[[0,0,1,0],
[0,0,1,0],
[0,1,1,0],
[0,1,0,0]]
This is very easy. Just keep a running pointer in the matrix and iterate over the binary string.
Now that you have a binary matrix, assume that it is a grid and you can walk on the 1s and not the 0s.
Given a starting coordinate, return the closest 1 on the edge of the grid that you can walk to.
Then return the total number of edges you can reach from the starting coordinate and walking only on the 1s.
Finally, mark the shortest path using Xs. This is easy - just use a hashmap mapping a cell to its parent cell on the path.
 * 
 * 
*/

public class BinaryStringMazeFindPath {
    public static void main(String[] args) {
        // int[][] grid = buildGrid("0010001001100100", 4, 4);    // [3, 1] shortest 
        // int[] closestPoint = findClosestPoints(grid, new int[]{0, 2});
        // System.out.println(closestPoint[0] + " , " + closestPoint[1]);

        int[][] grid = buildGrid("0010001101100100", 4, 4);    // [1, 3] shortest 
        int[] closestPoint = findClosestPoints(grid, new int[]{0, 2});
        System.out.println(closestPoint[0] + " , " + closestPoint[1]);

        List<int[]> allPoints = findAllEdgePoints(grid, new int[]{0, 2});
        markShorestPath(grid, new int[]{0, 2});
    }

    private static int[][] buildGrid(String bs, int col, int row){
        int[][] grid = new int[col][row];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                int curIndex = i * col + j;
                // String.valueOf(a);
                int num = Character.getNumericValue(bs.charAt(curIndex));  
                grid[i][j] = num;
                System.out.print(bs.charAt(curIndex));
            }
            System.out.println();
        }

        return grid;
    }

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[] findClosestPoints(int[][] grid, int[] s){
        int[] ans = new int[]{-1, -1};
        Queue<int[]> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.add(s);
        visited.add(String.valueOf(s[0]) + " , " + String.valueOf(s[1]));
        
        while(!que.isEmpty()){
            int[] curPos = que.poll();
            for (int[] dir : dirs){
                int nextX = dir[0] + curPos[0];
                int nextY = dir[1] + curPos[1];
                String pos = String.valueOf(nextX) + " , " + String.valueOf(nextY);
                if (nextX >= 0 && nextY >= 0 && nextY < grid.length && nextX < grid[0].length && grid[nextX][nextY] == 1 && !visited.contains(pos)) {
                    if (nextX == 0 || nextY == 0 || nextX == grid.length - 1 || nextY == grid[0].length - 1) {
                        ans[0] = nextX;
                        ans[1] = nextY;
                        return ans;
                    }

                    que.add(new int[]{nextX, nextY});
                    visited.add(pos);
                }
            }
        }

        return ans;
    }

    private static List<int[]> findAllEdgePoints(int[][] grid, int[] s){
        List<int[]> ans = new ArrayList<>();
        Queue<int[]> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.add(s);
        visited.add(String.valueOf(s[0]) + " , " + String.valueOf(s[1]));
        
        while(!que.isEmpty()){
            int[] curPos = que.poll();
            for (int[] dir : dirs){
                int nextX = dir[0] + curPos[0];
                int nextY = dir[1] + curPos[1];
                String pos = String.valueOf(nextX) + " , " + String.valueOf(nextY);
                if (nextX >= 0 && nextY >= 0 && nextY < grid.length && nextX < grid[0].length && grid[nextX][nextY] == 1 && !visited.contains(pos)) {
                    if (nextX == 0 || nextY == 0 || nextX == grid.length - 1 || nextY == grid[0].length - 1) {
                        ans.add(new int[]{nextX, nextY});
                    }

                    que.add(new int[]{nextX, nextY});
                    visited.add(pos);
                }
            }
        }

        System.out.println("all edge points");
        for (int[] p : ans){
            System.out.println(p[0] + " , " + p[1]);
        }
        return ans;
    }

    static class Path{
        List<int[]> nodes;
        public Path(){
            this.nodes = new ArrayList<>();
        }
    }

    private static void markShorestPath(int[][] grid, int[] s){
        Queue<Path> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Path ans = new Path();
        Path path = new Path();
        path.nodes.add(s);
        que.add(path);
        
        visited.add(String.valueOf(s[0]) + " , " + String.valueOf(s[1]));
        
        while(!que.isEmpty()){
            Path curPath = que.poll();
            int[] curPos = curPath.nodes.get(curPath.nodes.size() - 1);
            for (int[] dir : dirs){
                int nextX = dir[0] + curPos[0];
                int nextY = dir[1] + curPos[1];
                String pos = String.valueOf(nextX) + " , " + String.valueOf(nextY);
                if (nextX >= 0 && nextY >= 0 && nextY < grid.length && nextX < grid[0].length && grid[nextX][nextY] == 1 && !visited.contains(pos)) {
                    if (nextX == 0 || nextY == 0 || nextX == grid.length - 1 || nextY == grid[0].length - 1) {
                        curPath.nodes.add(new int[]{nextX, nextY});
                        ans = curPath;
                        break;
                    }

                    curPath.nodes.add(new int[]{nextX, nextY});
                    que.add(curPath);
                    visited.add(pos);
                }
            }
        }

        System.out.println("all edge points");
        for (int[] p : ans.nodes){
            System.out.println(p[0] + " , " + p[1]);
            grid[p[0]][p[1]] = 8;
        }

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                System.out.print(String.valueOf(grid[i][j]));
            }
            System.out.println();
        }
        
    }
}
