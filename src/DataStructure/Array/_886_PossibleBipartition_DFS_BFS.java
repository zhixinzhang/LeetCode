package DataStructure.Array;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/23/2021 10:44 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _886_PossibleBipartition_DFS_BFS {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < dislikes.length; i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(color[i] == 0){
                q.add(i);
                color[i] = 1;
                while(!q.isEmpty()){
                    int top = q.poll();

                    for(int child : adj[top]){
                        if(color[child]== color[top])
                            return false;
                        if(color[child] == 0)
                        {
                            color[child] = -color[top];
                            q.add(child);
                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean possibleBipartition_DFS(int n, int[][] dislikes) {

        int[][] graph = new int[n][n];
        for (int[] d : dislikes){
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }

        int[] group = new int[n];
        for (int i = 0; i < n; i++){
            if (group[i] == 0 && !dfs(graph, group, i, 1)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g){
        group[index] = g;
        for (int i = 0; i < graph.length; i++){
            if (graph[index][i] == 1){
                if (group[i] == g){
                    return false;
                }

                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }

        return true;
    }
}
