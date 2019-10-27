package google;

import java.util.*;

/**
 * @author Luke Zhang
 * @Date 2019-10-26 23:26
 */
public class _1059_AllPathsfromSourceLeadtoDestination_DFS {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        //build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            graph.putIfAbsent(edges[i][0], new HashSet<Integer>());
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        if (graph.containsKey(destination)) return false;
        return dfs(source, destination, new boolean[n], graph);
    }

    public boolean dfs(int source, int destination, boolean[] cache, Map<Integer, Set<Integer>> graph) {
        if (source == destination)
            return true;
        cache[source] = true; // mark source was visited
        if (!graph.containsKey(source)) return false;
        for (Integer node : graph.get(source))
            if (cache[node] || !dfs(node, destination, cache, graph)) return false;

        cache[source] = false;
        return true;
    }
}
