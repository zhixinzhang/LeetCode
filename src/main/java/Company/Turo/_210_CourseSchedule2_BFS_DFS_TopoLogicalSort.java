package DataStructure.Graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/6/19
 * Time: 2:21 PM
 * Description:
 */


public class _210_CourseSchedule2_BFS_DFS_TopoLogicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
        //prepare
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        //initail visited
        for(int i = 0; i < numCourses; i++){
            visited.put(i, 0);//0 -> unvisited, 1 -> visiting, 2 -> visited
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(!topoSort(res, graph, visited, i)) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    //the return value of this function only contains the ifCycle info and does not interfere dfs process. if there is Cycle, then return false
    private boolean topoSort(List<Integer> res, List<List<Integer>> graph, Map<Integer, Integer> visited, int i){
        int visit = visited.get(i);
        if(visit == 2){//when visit = 2, which means the subtree whose root is i has been dfs traversed and all the nodes in subtree has been put in the result(if we request), so we do not need to traverse it again
            return true;
        }if(visit == 1){
            return false;
        }

        visited.put(i, 1);
        for(int j : graph.get(i)){
            if(!topoSort(res, graph, visited, j)) return false;
        }
        visited.put(i, 2);
        res.add(i);//the only difference with traversing a graph

        return true;
    }
}
