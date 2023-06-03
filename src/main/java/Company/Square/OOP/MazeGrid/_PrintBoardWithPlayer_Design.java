package Company.Square.OOP.MazeGrid;
import java.util.*;

// https://www.1point3acres.com/bbs/thread-919874-1-1.html
// https://www.1point3acres.com/bbs/thread-906679-1-1.html
/**
 * 第六轮 Pair Coding:  print board with player
- - >‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌
- - -
- - -
只会有一个player，所以不用创建player object， 注意！！ player的方向可以用enum保存
主要的functionality就是printBoard，直接print就行不用存board

1. 设计一个nxn的board，里面有printBoard功能
2. 设计一个player，player有方向（东西南北），有位置
3. 把player放到board中，通过printBoard打印出player的所在位置和方向
如player在(1, 1)，朝向为南：
- - -
- v -
- - -
4. 输入一个字符串，字符串内包含player的下一步行动，FLR（前进，向左转，向右转），FLR可以重复出现
比如 FL，输入的结果就是
- - -
- - -
 * 
*/
public class _PrintBoardWithPlayer_Design {
    enum Direction {
        Up,
        Left,
        Right,
        Down
      }
  
     static class Player {
      int x;
      int y;
      Direction dir;
  
      public Player(int x, int y, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
      }
    }
    public static void main(String[] args) {
  
      int n = 5;
      String[][] grid = buildGrid(n);
      Player player = new Player(1, 1, Direction.Down);
  
      System.out.println("Displaying borad with player");
  
      printBoard(player, grid);
      
      System.out.println("Displaying new borad with player");
      movePlayer("FLR", player, grid);
    }
  
  
  
  
    private static String[][] buildGrid(int n){
      String[][] grid = new String[n][n];
      for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            grid[i][j] = "-";
        }
        System.out.println( Arrays.toString(grid[i]));
      }
  
      return grid;
    }
  
  
    private static void printBoard(Player player, String[][] grid){
      
      for (int i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
            if (i == player.x && j == player.y) { // we found out player
                switch (player.dir) {
                  case Down:
                    grid[i][j] = "v";
                    break;
                  case Up:
                    grid[i][j] = "^";
                    break;
                  case Right:
                    grid[i][j] = ">";
                    break;
                  case Left:
                    grid[i][j] = "<";
                    break;    
                  default:
                    break;
                }
            }
        }
        System.out.println( Arrays.toString(grid[i]));
      }
  
    }
  
    private static void movePlayer(String path, Player player, String[][] grid){
        if (path == null || path.length() == 0) {
          return;
        }
  
        // update player 
        char[] cPath = path.toCharArray();
        for (char c : cPath){
              switch (player.dir) {
                case Down:
                  if (c == 'F') {
                    int nextX = player.x + 1;
                    int nextY = player.y;
                    grid[nextX][nextY] = "v";
                    grid[player.x][player.y] = "-";
                    player.x = nextX;
                    player.y = nextY;
                  } else if (c == 'L') {
                    grid[player.x ][player.y] = ">";
                  } else if (c == 'R') {
                    grid[player.x ][player.y] = "<";
                  }
                  break;
                case Up:
                  if (c == 'F') {
                    int nextX = player.x - 1;
                    int nextY = player.y;
                    grid[nextX][nextY] = "^";
                    grid[player.x ][player.y] = "-";
                    player.x = nextX;
                    player.y = nextY;
                  } else if (c == 'L') {
                    grid[player.x ][player.y] = "<";
                  } else if (c == 'R') {
                    grid[player.x ][player.y] = ">";
                  }
                  break;
                case Right:
                  if (c == 'F') {
                    int nextX = player.x;
                    int nextY = player.y + 1;
                    grid[nextX][nextY] = ">";
                    grid[player.x ][player.y] = "-";
                    player.x = nextX;
                    player.y = nextY;
                  } else if (c == 'L') {
                    grid[player.x ][player.y] = "^";
                  } else if (c == 'R') {
                    grid[player.x ][player.y] = "v";
                  }
                  break;
                case Left:
                  if (c == 'F') {
                    int nextX = player.x;
                    int nextY = player.y - 1;
                    grid[nextX][nextY] = "<";
                    grid[player.x ][player.y] = "-";
                    player.x = nextX;
                    player.y = nextY;
                  } else if (c == 'L') {
                    grid[player.x ][player.y] = "v";
                  } else if (c == 'R') {
                    grid[player.x ][player.y] = "^";
                  }
                  break;    
                default:
                  break;
              }
        }
  
      for (int i = 0; i < grid.length; i++){
        System.out.println( Arrays.toString(grid[i]));
      }
  
    }
} 

