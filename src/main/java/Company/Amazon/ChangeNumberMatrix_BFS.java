package Company.Amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/21/19
 * Time: 7:13 PM
 * Description:
 * https://www.1point3acres.com/bbs/thread-517328-1-1.html
 *
 * 一道是BFS, 一个矩阵有2有1有0，每次操作使2的上下左右邻居1也变成2。0永远不变的。问能否把所有1变成2？最少几次操作？
 */


public class ChangeNumberMatrix_BFS {
    public int solve(int[][] matrix){

        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int nodeOne = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 2){
                    q.add(new int[]{i, j});
                    visited.add(String.valueOf(i) + "," + String.valueOf(j));
                }
                if(matrix[i][j] == 1)
                    nodeOne ++;
            }
        }
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++){
                int[] curNode = q.poll();
                for (int[] d : directions){
                    int nextX = curNode[0] + d[0];
                    int nextY = curNode[1] + d[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited.contains(String.valueOf(nextX) + "," + String.valueOf(nextY)))
                        continue;
                    if (matrix[nextX][nextY] == 0)  continue;
                    q.add(new int[]{nextX, nextY});
                    matrix[nextX][nextY] = 2;
                }
            }
        }

        return nodeOne == 0 ? level : -1;
    }
}
