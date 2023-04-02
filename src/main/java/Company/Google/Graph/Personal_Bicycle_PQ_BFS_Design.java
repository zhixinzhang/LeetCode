package google.Graph;

import java.util.*;

/**
 * Created by zhang on 2018/7/26.
 */
public class Personal_Bicycle_PQ_BFS_Design {
    public static class Pair{
        int distance;
        String p;
        String b;
        public Pair(int distance, String p, String b){
            this.distance = distance;
            this.p = p;
            this.b = b;
        }
    }
    static PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->(a.distance - b.distance));
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static int solution(char[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 'p'){
                    bfs(i,j,grid);
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        int res = 0;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            if (!visited.contains(p.p) && !visited.contains(p.b)){
                res+= p.distance;
                visited.add(p.p);
                visited.add(p.b);
            }
        }
        return res;
    }

    public static void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new int[]{i,j});
        visited.add(i + " " + j);
        int dis = 0;
        while (!q.isEmpty()){
            dis++;
            int size = q.size();
            for (int k = 0; k < size; k++){
                int[] cur = q.poll();
                for (int[] dir : dirs){
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                        continue;
                    int[] next = new int[]{nextX,nextY};
                    if (visited.contains(nextX + " "+ nextY))
                        continue;
                    if (grid[nextX][nextY] == 'b'){
                        pq.add(new Pair(dis,i + " " +j, nextX + " " + nextY));
                    }
                    q.add(new int[]{nextX,nextY});
                    visited.add(nextX + " "+ nextY);
                }
            }
        }
    }

    public static void main(String[] args){
        HashSet<int[]> hs = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        if (list.contains(new int[]{0,0})){
            System.out.println("ccc");
        }
        int[] next = new int[]{0,0};
        hs.add(next);
        if (hs.contains(next))
            System.out.println("ccc");
        solution(new char[][]{{'p','0','0','b'},{'p','b','0','0'},{'0','0','0','0'}});
    }



    static class PB{
        int distance;
        String p;
        String b;
        public PB(int distance, String p, String b){
            this.distance = distance;
            this.p = p;
            this.b = b;
        }
    }
    public static int hanmi_distance(int[][]p, int[][] b){
        if(p == null || p.length == 0 || b == null || b.length == 0)
            return 0;
        HashSet<String> visited = new HashSet<>();
        PriorityQueue<PB> pq = new PriorityQueue<>((a,c)->(a.distance - c.distance));
        // find min distance
        for (int[] person : p){
            String per = p[0] + " " + p[1];
            for (int [] by : b){
                String byi = by[0] + " " + by[1];
                int dis = Math.abs(by[0]-person[0]) + Math.abs(by[1] - person[1]);
                pq.add(new PB(dis,per,byi));
            }
        }
        int res = 0;
        while (pq.isEmpty()){
            PB pb = pq.poll();
            if (!visited.contains(pb.p) && !visited.contains(pb.b)){
                res += pb.distance;
                visited.add(pb.b);
                visited.add(pb.p);
            }
            if (visited.size() / 2 == p.length)
                return res;
        }
        return res;
    }
}
