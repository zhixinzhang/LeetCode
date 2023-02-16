package Company.Square;
import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-825957-1-1.html
 * 
 * Given R (number of rows) and C (number of columns), make an R x C grid and fill it with the characters in a binary string that is provided to you.
Example:
R = 4
C = 4
binaryString = "0010001001100100"
expected output:
[[0,0,1,0],
[0,0,1,0],
[0,1,1,0],
[0,1,0,0]]
*
Given a starting coordinate, return the closest 1 on the edge of the grid that you can walk to. 
*/
public class _BuildGrid_FindPath {
    public static void main(String[] args) {
        int col = 4;
        int row = 4;
        String path = "0010001001100100";
        char[][] grid = buildGrid(col, row, path);

        int[] start = new int[]{0, 2};
        // int edges = countAllEdges(start, grid);
        // System.out.println(edges);

        // grid = buildGrid(col, row, path);
        // int[] edge = findShortestEdgePosition(start, grid);
        // System.out.println(edge[0] + " " + edge[1]);

        grid = buildGrid(col, row, path);
        printShortestPath(start, grid);
    }

    private static char[][] buildGrid(int col, int row, String path){
        char[][] grid = new char[col][row];
        char[] cs = path.toCharArray();
        for (int i = 0; i < cs.length; i++){
            char c = cs[i];     // i = 1
            int curRow = i / row;   
            int curCul = i % col;
            grid[curRow][curCul] = c;
        }

        for (char[] curRow : grid){
            String a = new String(curRow);
            System.out.println(a);
        }
        return grid;
    }

    private static int[] findShortestEdgePosition(int[] start, char[][] grid){
        int col = grid[0].length;
        int row = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (start == null || start.length <= 1 || grid[start[0]][start[1]] != '1') {
            return new int[]{0, 0};
        }

        //BFS 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        grid[start[0]][start[1]] = '2';

        while(!queue.isEmpty()){
            int[] cuPosition = queue.poll();
            for (int[] dir : dirs){
                int nextX = dir[0] + cuPosition[0];
                int nextY = dir[1] + cuPosition[1];
                if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row || grid[nextX][nextY] != '1') {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                grid[nextX][nextY] = '2';
                if (nextX == 0 || nextX == row - 1 || nextY == 0 || nextY == col - 1) {   // we are in edge
                    return new int[]{nextX, nextY};
                }
            }
        }
        
        return new int[]{0, 0};
    }

    private static int countAllEdges(int[] start, char[][] grid){
        int countEdge = 0;
        int col = grid[0].length;
        int row = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (start == null || start.length <= 1 || grid[start[0]][start[1]] != '1') {
            return 0;
        }

        //BFS 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        grid[start[0]][start[1]] = '2';

        while(!queue.isEmpty()){
            int[] cuPosition = queue.poll();
            for (int[] dir : dirs){
                int nextX = dir[0] + cuPosition[0];
                int nextY = dir[1] + cuPosition[1];
                if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row || grid[nextX][nextY] != '1') {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                grid[nextX][nextY] = '2';
                if (nextX == 0 || nextX == row - 1 || nextY == 0 || nextY == col - 1) {
                    countEdge ++;
                }
            }
        }
        
        return countEdge;
    }

    static class Path {
        public List<int[]> visitedPoint;
        public Path(){
            this.visitedPoint = new ArrayList<>();
        }

        public Path(List<int[]> startNode){
            this.visitedPoint = startNode;
        }
        
    }
    private static void printShortestPath(int[] start, char[][] grid){
        int col = grid[0].length;
        int row = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //BFS 
        Queue<Path> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
       
        List<int[]> startNode = new ArrayList<>();
        startNode.add(new int[]{start[0], start[1]});
        queue.add(new Path(startNode));
        visited.add(String.valueOf(start[0]) + "#" + String.valueOf(start[1]));

        while(!queue.isEmpty()){
            Path cuPath = queue.poll();
            List<int[]> path = cuPath.visitedPoint;
            int[] cuPosition = cuPath.visitedPoint.get(cuPath.visitedPoint.size() - 1);
            
            for (int[] dir : dirs){
                int nextX = dir[0] + cuPosition[0];
                int nextY = dir[1] + cuPosition[1];
                String nextP = String.valueOf(nextX) + "#" + String.valueOf(nextY);
                if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row || grid[nextX][nextY] != '1' || visited.contains(nextP)) {
                    continue;
                }
                
                List<int[]> nextPath = new ArrayList<>();
                nextPath.addAll(path);
                nextPath.add(new int[]{nextX, nextY});
                visited.add(nextP);
                queue.add(new Path(nextPath));
                if (nextX == 0 || nextX == row - 1 || nextY == 0 || nextY == col - 1) {   // we are in edge
                    // print path
                    System.out.print("we found out the shortest path");
                    for (int[] cell : nextPath){
                        System.out.print("[" + String.valueOf(cell[0]) + " , " + String.valueOf(cell[1]) + "]");

                        grid[cell[0]][cell[1]] = 'x';
                    }

                    // path grid
                    System.out.println("printed new grid");
                    for (char[] curRow : grid){
                        String a = new String(curRow);
                        System.out.println(a);
                    }
                }
            }
        }
        
        
    }

}
