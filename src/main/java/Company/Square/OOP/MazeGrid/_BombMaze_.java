package Company.Square.OOP.MazeGrid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
https://www.1point3acres.com/bbs/thread-992155-1-1.html
* 1. coding，迷宫题，n*n grid 1为block, 2是bomb，0可通过，求左上到右下的最短路径，
直接bfs，followup是小人有超能力，可以挨一个bomb，大概说了思路后说不用写了，直接快进到可以挨k个bomb。
 * 
 * 
*/
public class _BombMaze_ {
    public static void main(String[] args) {
        int[][] maze = new int[][]{
            {0, 0, 0, 2, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };

        countShortestPath(maze, new int[]{0, 0}, new int[]{4, 4});   // out put 7
        findShortestPath(maze, new int[]{0, 0}, new int[]{4, 4});   // out put 7

        int[][] maze2 = new int[][]{
            {0, 0, 2, 2, 0},
            {0, 1, 2, 1, 2},
            {0, 1, 2, 1, 2},
            {0, 1, 0, 1, 0},
            {2, 0, 0, 2, 0}
        };

        findShortestPathWithKBomb(maze2, new int[]{0, 0}, new int[]{4, 4}, 2);
    }

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int countShortestPath(int[][] maze, int[] start, int[] end){
        int ans = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] curPos = queue.poll();   // [0, 0]
                for (int[] dir : dirs){
                    int nextX = dir[0] + curPos[0];
                    int nextY = dir[1] + curPos[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && !visited[nextX][nextY]) {
                        if (maze[nextX][nextY] == 2 || maze[nextX][nextY] == 1)
                            continue;
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;

                        if (nextX == end[0] && nextY == end[1]) {
                            return ans;
                        }
                    }
                }

            }
            ans ++;
        }

        return ans;
    }

    static class Robot {
        List<int[]> path;
        int take;
        public Robot(){
            this.path = new ArrayList<>();
            this.take = 0;
        }   
    }
    
    private static int findShortestPath(int[][] maze, int[] start, int[] end){
        int ans = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Robot> queue = new ArrayDeque<>();
        Robot rob = new Robot();
        rob.path.add(start);
        queue.add(rob);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Robot curRob = queue.poll();
                int[] curPos = curRob.path.get(curRob.path.size() - 1);   // [0, 0]
                for (int[] dir : dirs){
                    int nextX = dir[0] + curPos[0];
                    int nextY = dir[1] + curPos[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && !visited[nextX][nextY]) {
                        if (maze[nextX][nextY] == 2 || maze[nextX][nextY] == 1)
                            continue;

                        Robot newRobot = new Robot();
                        newRobot.path.addAll(curRob.path);
                        newRobot.path.add(new int[]{nextX, nextY});

                        queue.add(newRobot);
                        visited[nextX][nextY] = true;

                        if (nextX == end[0] && nextY == end[1]) {
                            printPath(newRobot);
                            return ans;
                        }
                    }
                }

            }
            ans ++;
        }

        return ans;
    }

    private static void printPath(Robot robot){
        for (int[] pos : robot.path){
            System.out.println(pos[0] + " , " + pos[1]);
        }

        System.out.println("Robot take bomb : " + robot.take);
    }

    private static int findShortestPathWithKBomb(int[][] maze, int[] start, int[] end, int k){
        int ans = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Robot> queue = new ArrayDeque<>();
        Robot rob = new Robot();
        rob.path.add(start);
        queue.add(rob);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Robot curRob = queue.poll();
                int[] curPos = curRob.path.get(curRob.path.size() - 1);   // [0, 0]
                for (int[] dir : dirs){
                    int nextX = dir[0] + curPos[0];
                    int nextY = dir[1] + curPos[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && !visited[nextX][nextY]) {
                        if (maze[nextX][nextY] == 1)
                            continue;
                        int take = curRob.take;
                        if (maze[nextX][nextY] == 2) {
                            if ( curRob.take + 1 <= k) {
                                take = curRob.take + 1;
                            } else {
                                continue;
                            }
                        }

                        Robot newRobot = new Robot();
                        newRobot.take = take;
                        newRobot.path.addAll(curRob.path);
                        newRobot.path.add(new int[]{nextX, nextY});

                        queue.add(newRobot);
                        visited[nextX][nextY] = true;

                        if (nextX == end[0] && nextY == end[1]) {
                            printPath(newRobot);
                            return ans;
                        }
                    }
                }

            }
            ans ++;
        }

        return ans;
    }
}
