package google.Graph;

import google.Design.Robot;

import java.util.HashSet;

/**
 * Created by zhang on 2018/8/14.
 */
public class _489_RobotRoomCleaner_DFS {
    public void cleanRoom(Robot robot){
        // A number can be added to each visited cell
        // use string to identify the class
        HashSet<String> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, 0);
    }
    public void backtrack(Robot robot, HashSet<String> set, int i,
                          int j, int cur_dir) {

        String tmp = i + "->" + j;
        if(set.contains(tmp)) {
            return;
        }

        robot.Clean();
        set.add(tmp);
        for (int n = 0; n<4; n++){
            if (robot.Move()){
                int x = i, y = j;
                switch (cur_dir){
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
//                robot.turnLeft();
//                robot.turnLeft();
//                robot.move();
//                robot.turnRight();
//                robot.turnRight();
            }
            robot.TurnRight(1);
            cur_dir += 90;
            cur_dir %= 360;
        }
    }
}
