package Company.Google.Graph;


import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-18 16:23
 * <p>
 * Description:
 * Key Point:
 */
public class _864_ShortestPathtoGetAllKeys_BFS {
    static class Pair{
        int x, y;
        int keySum;
        char[] keys;
        Pair(int x, int y, int keySum, char[] keys){
            this.x = x;
            this.y = y;
            this.keySum = keySum;
            this.keys = keys;
        }
    }
    public  static int shortestPathAllKeys(String[] grid) {
        if (grid == null || grid.length == 0 || grid[0].length() == 0)  return 0;
        int m = grid.length;
        int n = grid[0].length();
        HashSet<Integer> ks = new HashSet<>();
        int[] start = new int[]{-1,-1};
        char[] keys = new char[7];
        Arrays.fill(keys,' ');
        int keySum = 0;
        for (int i = 0; i<m; i++){
            String curS = grid[i];
            for (int j = 0; j<n; j++){
                if(curS.charAt(j) == '@'){
                    start[0] = i; start[1] = j;
                }
                if (curS.charAt(j)>='a' && curS.charAt(j) <= 'f'){
                    keys[curS.charAt(j) - 'a'+1] = curS.charAt(j);
                    keySum++;
                }
            }
        }
        if (start[0] == -1) return -1;
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Pair(start[0],start[1],keySum,keys));

        String c =  String.valueOf(keys);
        visited.add(c + " " + String.valueOf(start[0]) + " " + String.valueOf(start[1]));
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int path = 0;
        while (!q.isEmpty()){
            int size = q.size();
            path++;
            while (size-- > 0){
                Pair p = q.poll();
                for (int[] d : dirs){
                    int x = p.x + d[0];
                    int y = p.y + d[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x].charAt(y) == '#'){
                        continue;
                    }
                    if (grid[x].charAt(y) == '.'){
                        Pair curP = new Pair(x,y,p.keySum,p.keys);
                        if (!visited.contains(curP))
                            q.offer(curP);
                    }
                    if (grid[x].charAt(y) >= 'A' || grid[x].charAt(y) <= 'F'){
                        char Lock = grid[x].charAt(y);
                        if (p.keys[Lock - 'A' + 1] == ' '){
                            Pair curP = new Pair(x,y,p.keySum,p.keys);
                            if (!visited.contains(curP))
                                q.offer(curP);
                        }
                    }
                    if (grid[x].charAt(y) >= 'a' || grid[x].charAt(y) <= 'f'){
                        char k = grid[x].charAt(y);
                        p.keySum--;
                        if (p.keySum == 0) return path;
                        p.keys[k - 'a' + 1] = ' ';
                        Pair curP = new Pair(x,y,p.keySum,p.keys);
                        if (!visited.contains(curP))
                            q.offer(curP);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String[] grid = new String[]{"@.a.b","###.#","c.A.B"};
        System.out.println(shortestPathAllKeys(grid));
    }

    class State {
        int keys, i, j;
        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathAllKeys_Right(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
