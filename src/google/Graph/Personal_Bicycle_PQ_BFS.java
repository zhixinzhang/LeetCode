package google.Graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhang on 2018/7/3.
 */
class Pair{
    int[] p;
    int[] b;
    int distance;
    Pair(int[] p, int[] b, int distance){
        this.p = p;
        this.b = b;
        this.distance = distance;
    }
}
public class Personal_Bicycle_PQ_BFS {
    static PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->(a.distance - b.distance));
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void solution(char[][] graph){
        if(graph == null || graph.length == 0 || graph[0].length == 0)
            return;
        int m = graph.length, n = graph[0].length;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (graph[i][j] == 'p')
                    bfs(i,j,graph);
            }
        }
        return;
    }
    public static void bfs(int i, int j, char[][] graph){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int minDis = 0;
        while (!q.isEmpty()){
            int[] curP = q.poll();
            minDis++;
            for (int[] d : dirs){
                int[] nextP = new int[2];
                nextP[0] = curP[0] + d[0];
                nextP[1] = curP[1] + d[1];
                if (nextP[0] >= 0 && nextP[0] < graph.length && nextP[1] >= 0 && nextP[1] < graph[0].length){
                    if (graph[nextP[0]][nextP[1]] == 'b'){
                        Pair pair = new Pair(new int[]{i,j},nextP,minDis);
                        pq.add(pair);
                        graph[nextP[0]][nextP[1]] = 'e';
                    }else{
                        q.add(nextP);
                    }
                }
            }
        }
    }

    public static Pair nextPair(PriorityQueue<Pair> pq){
        return pq.poll();
    }
}
