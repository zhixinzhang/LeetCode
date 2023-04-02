package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/16.
 * 时间复杂度:O(N + E) (因为搜索了所有的节点和所有的边)
 空间复杂度:O(10001 * 2)=O(1)
 */
public class _802_FindEventualSafeStates_DFS {
    //     value of color represents three states:
// 0:have not been visited
// 1:safe
// 2:unsafe
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // detect cycle
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)   return res;
        int nodeCount = graph.length;
        int[] color = new int[nodeCount];
        for(int i = 0; i<nodeCount;  i++){
            if(dfs(graph, i, color))
                res.add(i);
        }
        return res;
    }
    private boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0)           // we visited the node
            return color[start] == 1;
        color[start] = 2;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, color))
                return false;
        }
        color[start] = 1;
        return true;

    }
}
