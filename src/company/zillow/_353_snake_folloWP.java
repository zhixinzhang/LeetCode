package company.zillow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhang on 2018/9/26.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=341619&ctid=201331
 * 第一轮同胞，聊天扯淡，二维坐标实现贪吃蛇的 move 方法，返回有木有撞到自己
 */
public class _353_snake_folloWP {
    // zillow
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] board;
    static Deque<int[]> path = new LinkedList<>();
    public static void main(String[] args){
        SnakeGame sg = new SnakeGame(5,5,new int[][]{{3,3},{3,4},{5,0},{2,3}});
        board = sg.borad;
        move('U');
    }
    public static boolean move(char d){
        int[] head = path.getFirst();
        switch (d){
            case 'U' : {
                head[0] = head[0] + 1;break;
            }
            case 'D':{
                head[0] = head[0] - 1;break;
            }
            case 'R':{
                head[1] = head[1] + 1;break;
            }
            case 'L':{
                head[1] = head[1] -1; break;
            }
        }
        

        return false;
    }

}
class SnakeGame{
    int n, m;
    int[][] food;
    int[][] borad;
    public SnakeGame(int n, int m, int[][] food){
        this. n = n;
        this.m = m;
        this.food = food;
        this.borad = new int[n][m];
        for(int[] f : food){
            borad[f[0]][f[1]] = 5;
        }
    }
}