package Company.Robinhood;
import java.util.*;

/**
 * Q2: DFS from the entry node and every time you pass through a node, increment counter for that node. In the end the counters will be the load factor of the nodes.
You'll have to create the adjacency list first, then do the dfs.

O(V+E) runtime
O(V+E) space

https://leetcode.com/discuss/interview-question/1681871/robinhood-vo-staff
 * 
*/
public class _MicroDependencies_ {
    public static void main(String[] args) {
        _MicroDependencies_ algo = new _MicroDependencies_();
        String[] service_list = {"logging=",
                "user=logging",
                "orders=user,foobar",
                "recommendations=user,orders",
                "dashboard=user,orders,recommendations"};
    
        String entrypoint = "dashboard";
    
        List<String> result = algo.loadFactorDagTopoSort(service_list, entrypoint);
        for (String s : result) {
          System.out.println(s);
        }
      }

    public static List<String> loadFactorDagTopoSort(String[] serviceList, String entryPoint) {
        Map<String, List<String>> adj = new HashMap<>();
    
        for (String sl : serviceList) {
          String[] slArr = sl.split("=");
          String service = slArr[0];
    
    
          // non-existent dependency references should be ignored
          adj.putIfAbsent(service, new ArrayList<>());
    
          if (slArr.length > 1) {
            String[] dependencies = slArr[1].split(",");
            for (String dep : dependencies) {
              if (!dep.isEmpty()) {
                adj.get(service).add(dep);
              }
            }
          }
        }
    
        Map<String, Integer> counter = new HashMap<>();
        Set<String> visited = new HashSet<>();
        dfs(entryPoint, visited, adj, counter);
    
        SortedSet<String> keys = new TreeSet<>(counter.keySet());
        List<String> result = new ArrayList<>();
        for (String s : keys) {
          result.add(s + "*" + counter.get(s));
        }
        return result;
      }
    
      public  static void dfs(String service, Set<String> visited,
                      Map<String, List<String>> adj, Map<String, Integer> counter) {
        if (visited.contains(service))
          return;
    
        counter.put(service, counter.getOrDefault(service, 0) + 1);
    
        visited.add(service);
    
        for (String nei : adj.get(service)) {
          if (adj.containsKey(nei))
            dfs(nei, visited, adj, counter);
        }
        visited.remove(service);
      }

}
