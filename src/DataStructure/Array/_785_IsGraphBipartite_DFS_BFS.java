package DataStructure.Array;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-21 16:23
 * <p>
 * Description:
 * Key Point:
 *
 * It is a graph coloring problem. The basic idea is using group[i] to denote the group where ith node belongs to:
 *
 * Initialize the group of each node to -1
 * dfs the graph to set the group of node whose group is -1.
 * If conflict occurs, return false.
 * Note that any two nodes on an edge must belong to different group.
 *
 * Time Complexity: O(N + E)   O(N+E), where NN is the number of nodes in the graph, and EE is the number of edges. We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.
 *
 * Space Complexity: O(N)O(N), the space used to store the color.
 */

public class _785_IsGraphBipartite_DFS_BFS {

    // I assume the graph is connected
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0 && !validColor(g, colors, 1, i))
                return false;
        return true;
    }

    boolean validColor(int[][] g, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for (int adjacent : g[node])
            if (!validColor(g, colors, -color, adjacent))
                return false;
        return true;
    }


    // BFS
    public boolean isBipartite_BFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
