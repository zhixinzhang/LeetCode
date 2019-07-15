package DataStructure.Graph;

/**
 * Created by zhang on 2018/3/25.
 * https://leetcode.com/problems/course-schedule/description/
 */
// numCourses 4

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**         0 ---> 1 --->  4 ---> 5
 *                              /
 *                             /
 *                   8 <--     6
 *   [1,0],[4,1],[5,4],[6,5],[8,6]  numscourses = 5
 *   拓扑排序  bfs dfs 两种方法
 **/
public class _207_CourseSchedule_BFS_DFS {
    public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] pair:prerequisites){          // 求入度
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){     // 求起始点
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){                //遍历起始点
            numCourses--;
            int course = queue.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==0;
    }

    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        // find root node
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0;i<numCourses;i++)
            graph[i] = new ArrayList();

        int[] visited = new int[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }
    private boolean dfs(ArrayList[] graph, int[] visited, int course){
        if(visited[course] == -1)
            return false;
        if(visited[course] == 1)
            return true;
        visited[course] = -1;
        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = 1;
        return true;
    }
}
