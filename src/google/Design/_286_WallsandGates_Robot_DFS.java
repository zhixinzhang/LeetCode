package google.Design;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhang on 2018/6/20.
 * http://www.1point3acres.com/bbs/thread-345555-3-1.html
 *
 * follo up  low battery 怎么办
 * 我的想法是 找到一个墙角 然后绕着墙角走
 *
 * LC  286. Walls and Gates
 *
 */
public class _286_WallsandGates_Robot_DFS {

    Robot robot = new Robot();
    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        Set<String> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<String> set, int i,
                          int j, int cur_dir) {
        String tmp = i + "->" + j;
        if(set.contains(tmp)) {
            return;
        }

        robot.Clean();
        set.add(tmp);

        for(int n = 0; n < 4; n++) {
            // the robot can to four directions, we use right turn
            if(robot.Move()) {
                // can go directly. Find the (x, y) for the next cell based on current direction
                int x = i, y = j;
                switch(cur_dir) {
                    case 0:
                        // go up, reduce i
                        x = i-1;
                        break;
                    case 90:
                        // go right
                        y = j+1;
                        break;
                    case 180:
                        // go down
                        x = i+1;
                        break;
                    case 270:
                        // go left
                        y = j-1;
                        break;
                    default:
                        break;
                }

                backtrack(robot, set, x, y, cur_dir);
                // go back to the starting position
                robot.TurnLeft(1);
                robot.TurnLeft(1);
                robot.Move();
                robot.TurnLeft(1);
                robot.TurnLeft(1);

            }
            // turn to next direction
            robot.TurnRight(1);
            cur_dir += 90;
            cur_dir %= 360;
        }
    }
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};   //west south east north
    //    String[] dirs = new String[]{"R","L","U","D"};
    public void solution(Robot r){
        HashSet<int[]> visited = new HashSet<>();
        // start as (0,0)
        int[] curPos = new int[]{0,0};
        dfs(r,visited, curPos,3);
    }
    public void dfs(Robot r, HashSet<int[]> visited, int[] curPos, int faceTo){
        if (visited.contains(curPos)) return;
        r.Clean();
        visited.add(curPos);
        //During each for loop iteration, the robot will turn left 90 degree
        //so after the for loop finish, the robot will face toward its original direction
        for (int i = 0; i< dirs.length; i++){
            //faceTo is always between 0 to 3 inclusive
            faceTo = (faceTo + 1) % dirs.length;
            robot.TurnLeft(1);    //turn left 90 degree
            int[] nextPos = curPos;
            nextPos[0] = dirs[i][0] + nextPos[0];
            nextPos[1] = dirs[i][1] + nextPos[1];
            if (robot.Move()){
                dfs(r,visited,nextPos,faceTo);
                moveBack(robot);
            }else{
                visited.add(nextPos);
            }
        }

    }
    void moveBack(Robot robot){
        robot.TurnLeft(2);
        robot.Move();
        robot.TurnLeft(2);
    }
}
