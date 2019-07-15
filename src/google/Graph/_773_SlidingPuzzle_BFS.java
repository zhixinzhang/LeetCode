package google.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/8/1.
 */
public class _773_SlidingPuzzle_BFS {
    static String target = "123450";
    public static int slidingPuzzle(int[][] board) {
        if(board == null || board.length < 2 || board[0].length < 3)    return 0;
        HashSet<String> visited = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        visited.add(start);
        q.add(board);
        int level = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[][] tempB = q.poll();
                int[] curZero = find(tempB);
                for(int[] d : dirs){
                    int nx = curZero[0] + d[0];
                    int ny = curZero[1] + d[1];
                    if(nx < 0|| ny < 0|| nx >= 2|| ny >= 3)
                        continue;
                    int[][] nextB = swap(tempB,curZero[0],curZero[1], nx,ny);
                    String curS;
                    curS = convert(nextB);
                    if(!visited.contains(curS)){
                        visited.add(curS);
                        q.add(nextB);
                    }
                    if (curS.equals(target))
                        return level;
                }
            }

        }
        return -1;
    }
    public static int[] find(int[][] board){
        for(int i = 0; i<2; i++){
            for(int j = 0; j<3;j++){
                if(board[i][j] == 0)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    public static int[][] swap(int[][] t,int i, int j, int x, int y){
        int[][] res = t.clone();
        int temp = res[x][y];
        res[x][y] = 0;
        res[i][j] = temp;
        return res;
    }
    public static String convert(int[][] b){
        String start = "";
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                start += b[i][j];
            }
        }
        return start;
    }

    public static void main(String[] args){
        slidingPuzzle(new int[][]{{4,1,2},{5,0,3}});
    }
}
