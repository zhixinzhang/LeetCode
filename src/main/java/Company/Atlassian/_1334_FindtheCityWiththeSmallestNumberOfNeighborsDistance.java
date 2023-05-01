package Company.Atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1334_FindtheCityWiththeSmallestNumberOfNeighborsDistance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
    	Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    	
    	for (int[] edge : edges) {
    		if (!graph.keySet().contains(edge[0]))
    			graph.put(edge[0], new HashMap <>());
    		
    		graph.get(edge[0]).put(edge[1], edge[2]);
    		
    		if (!graph.keySet().contains(edge[1]))
    			graph.put(edge[1], new HashMap <>());
    		
    		graph.get(edge[1]).put(edge[0], edge[2]);
    	}
    	
    	int min = Integer.MAX_VALUE;
    	int res = -1;
    	
    	for (int i = 0; i < n; i++) {
    		PriorityQueue <int[]> pq = new PriorityQueue <>((a,b) -> (Integer.compare(a[1], b[1])));
    		boolean[] visited = new boolean [n];
    		int count = 0;
    		pq.add(new int[] {i, 0});
    		
    		while(!pq.isEmpty()) {
    			int[] cur = pq.poll();
    			int curNode = cur[0];
    			int curDist = cur[1];
    			
    			if (visited[curNode])
    				continue;
    			
    			visited[curNode] = true;
    			
    			count ++;
    			
    			if (graph.keySet().contains(curNode)) {
        			for (int adj : graph.get(curNode).keySet()) {
        				if (!visited[adj] && curDist + graph.get(curNode).get(adj) <= distanceThreshold)
        					pq.add(new int[] {adj, curDist + graph.get(curNode).get(adj)});
        			}
    			}
    		}
    		
    		if (count - 1 <= min) {
    			min = count - 1;
    			res = i;
    		}
    	}
    	
    	return res;
    }
}
