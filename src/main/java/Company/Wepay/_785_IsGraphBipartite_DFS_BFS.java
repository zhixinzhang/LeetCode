package Company.Wepay;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean isBipartite(int[][] graph) {
        int group[] = new int[graph.length];
        Arrays.fill(group, -1);
        for(int i = 0; i < graph.length; i++) {
            if( group[i] == -1 && !help(i, graph, group, 0) )
                return false;
        }
        return true;
    }

    public boolean help(int index, int[][] graph, int group[], int color) {
        if( group[index] == color )
            return true;
        group[index] = color;
        for(int i = 0; i < graph[index].length; i++) {
            if( group[graph[index][i]] == color || !help(graph[index][i], graph, group, 1 - color) )
                return false;
        }
        return true;
    }

    // DFS + Stack

    public boolean isBipartite_DFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

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
