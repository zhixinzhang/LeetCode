package Company.Google.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/26/19
 * Time: 6:12 PM
 * Description:
 * \
 *https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=516622&page=1&authorid=415544
 *
 * 给一个只有0和1的matrix, 1代表可以走，0代表blocked, 问从第一行任意位置开始走能不能走到最后一行。follow up 1: output the path, can be any path，
 * follow up 2: 如果现在matrix里都是大于0的integer, 一开始的cost是0，每走到一个cell当前cost就加上那个cell里的数字，问从第一行走到最后一行最小cost
 */


public class FirstRowToBottomMatrix_DFS_DP {
    List<int[]> path = new ArrayList<>();
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    public void findPath(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  return;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < m; i++){
            if (matrix[0][i] == 1){
                if (i >= 1 && matrix[0][i-1] == 1)  continue;
                boolean ans = dfs(matrix, 0, i, n, m);
                if (ans)
                    break;
            }
        }
    }
    public boolean dfs(int[][] matrix, int x, int y, int n, int m){
        if (x == n-1) {
            path.add(new int[]{x, y});
            return true;
        }
        for (int[] d : directions){
            int nextX = d[0] + x;
            int nexty = d[1] + y;
            if (nextX < 0 || nexty < 0 || nextX >= n || nexty >= m || visited[nextX][nexty])
                continue;
            path.add(new int[]{nextX,nexty});
            visited[nextX][nexty] = true;
            boolean ans = dfs(matrix, nextX, nexty,n,m);
            if (ans)    return true;
            path.remove(path.size()-1);
            visited[nextX][nexty] = false;
        }
        return false;
    }
}
