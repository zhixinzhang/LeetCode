package google.Graph;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/8/7.
 * 第一题：给一个sorted list，一个target number，只用get method查找target number.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=436447&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 *
 第二题：给一个int matrix，一个初始power，给start point和end point，matrix里1代表路可以走，2代表墙不能走，3要减一，4要加一，求问从start走到end可以得到的最大值。
 */
public class _778_FIndTarget_MaxValue_PQ {
    class Pair{
        int val;
        int[] pos;
        Pair(int val, int[] pos){
            this.val = val;
            this.pos = pos;
        }
    }
    public int solu(int[][] matrix){
        // corner case
        if (matrix == null || matrix.length == 0)
            return 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int n = matrix.length;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] vis = new boolean[n][n];
        minHeap.add(new Pair(matrix[0][0], new int[]{0,0}));
        vis[0][0] = true;
        while (!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int[] curPos = p.pos;
            for (int[] d : dirs){
                int nx = d[0] + curPos[0];
                int ny = d[1] + curPos[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny])
                    continue;
                vis[nx][ny] = true;
                if (matrix[nx][ny] == 5){
                    return p.val + matrix[nx][ny];
                }
                Pair np = new Pair(p.val + matrix[nx][ny], new int[]{nx,ny});
                minHeap.add(np);
            }
        }
        return -1;
    }
}
