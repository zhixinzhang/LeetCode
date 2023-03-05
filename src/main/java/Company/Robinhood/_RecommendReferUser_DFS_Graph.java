package Company.Robinhood;
import java.util.*;

// Coding 是推荐用户的个数，
// rh_users = { "A", "B", "C" };
// new_users = { "B", "C", "D" };
// https://www.1point3acres.com/bbs/thread-847942-1-1.html
// https://www.1point3acres.com/bbs/thread-821883-1-1.html
// https://www.1point3acres.com/bbs/thread-850766-1-1.html

public class _RecommendReferUser_DFS_Graph {
    public static void main(String[] args){
        String[][] input = new String[][]{
            {"A", "B", "C"},
            {"B", "F", "D"},
            {"E", "C", "H"},
        }; 
        findRecommendFactor(input);
    }

    private static void findRecommendFactor(String[][] inputs){
        Map<String, Integer> recoFactor = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> entryNodes = new HashSet<>(Arrays.asList(inputs[0]));
        for (int i = 0; i < inputs[0].length; i++){
            String startNode = inputs[0][i];
            graph.putIfAbsent(startNode, new ArrayList<>());
            for (int j = 1; j < inputs.length; j++){
                graph.get(startNode).add(inputs[j][i]);
                graph.putIfAbsent(inputs[j][i], new ArrayList<>());

                if (entryNodes.contains(inputs[j][i])) {
                    entryNodes.remove(inputs[j][i]);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        for (String entryNode : entryNodes){
            dfs(graph, recoFactor, visited, entryNode);
        }
    
        SortedSet<String> keys = new TreeSet<>(recoFactor.keySet());
        for (String s : keys) {
          System.out.println(s + ":" + String.valueOf(recoFactor.get(s)));
        }
    }

    private static int dfs(Map<String, List<String>> graph, Map<String, Integer> recoFactor, Set<String> visited, String entryNode){
        if (visited.contains(entryNode)) {
            return 0;
        }
        if (graph.get(entryNode).isEmpty()) {   // find out leaf node
            recoFactor.put(entryNode, 1);
            return 1;
        }
        int count = 0;
        visited.add(entryNode);

        for (String nei : graph.get(entryNode)){
            count += dfs(graph, recoFactor, visited, nei);
        }

        visited.remove(entryNode);
        recoFactor.put(entryNode, count);
        count ++;
        return count;
    }
}
