package company.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/25/19
 * Time: 11:23 AM
 * Description:
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 *
 *
 Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
 Initialize a color[] array for each node. Here are three states for colors[] array:
 0: Haven't been colored yet.
 1: Blue.
 -1: Red.
 For each node,

 If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
 If it has been colored, check if the current color is the same as the color that is going to be used to color it. (Please forgive my english... Hope you can understand it.)

 */


public class _785_IsGraphBipartite_DFS_BFS {
    public boolean isBipartite_DFS(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0)
            return false;
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++){
            int[] cur = graph[i];
            if (colors[i] == 0 && !dfs(graph, colors, 1, i))
                return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] colors, int color, int node){
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        for (int next : graph[node]){
            if (!dfs(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;

    }


    public boolean isBipartite_BFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++){
            if (colors[i] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!q.isEmpty()){
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        q.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
