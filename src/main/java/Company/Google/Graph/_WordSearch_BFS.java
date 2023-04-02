package Company.Google.Graph;


import java.util.*;

/**
 * Created by zhang on 2018/8/12.
 */
public class _WordSearch_BFS {
    class Pair{
        StringBuilder s;
        int idx;
        int[] position;
        HashSet<String> vis;
        Pair(int[] position){
            this.position = position;
            vis = new HashSet<>();
            s = new StringBuilder();
            idx = 0;
        }
    }

    public List<String> findSmallestWord(char[][] words, String target){
        List<String> res = new ArrayList<>();
        int n = words.length, m = words[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i<n; i++){
            for (int j = 0; j < m; j++){
                if (words[i][j] == target.charAt(0)){
                    Pair p = new Pair(new int[]{i,j});
                    p.s.append(target.charAt(0));
                    String path = String.valueOf(i) + "*" + String.valueOf(j);
                    p.vis.add(path);
                    q.add(p);
                }
            }
        }
        if (q.isEmpty())
            return res;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        int level = 0;
        while (!q.isEmpty()){
            level++;
            int size = q.size();
            for (int i = 0; i< size; i++){
                Pair curP = q.poll();
                char c = target.charAt(curP.idx);
                int[] curPos = curP.position;
                StringBuilder curS = curP.s;
                for (int[] dir : dirs){
                    int idx = curP.idx;
                    int nx = dir[0] + curPos[0];
                    int ny = dir[1] + curPos[1];
                    String path = String.valueOf(nx) + "*" + String.valueOf(ny);
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || curP.vis.contains(path))
                        continue;
                    curS.append(c);
                    if (words[nx][ny] == c){
                        idx++;
                        if (idx == target.length())
                            res.add(curS.toString());
                    }else {
                        Pair newPair = new Pair(new int[]{nx, ny});
                    }
                }
            }
            if (res.size() > 0)
                break;
        }
        return res;
    }
}
