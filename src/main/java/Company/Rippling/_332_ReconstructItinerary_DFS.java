package Company.Rippling;
import java.util.*;

/**
 * 
 * All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.

The graph must be Eulerian since we know that a Eulerian path exists.

Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Eulerian path in the graph which is a valid reconstruction.

Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.
 * 
*/
public class _332_ReconstructItinerary_DFS {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return path;
        }
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (List<String> ticket : tickets){
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");
        return path;
    }

    private void dfs(String start){
        PriorityQueue<String> pq = flights.get(start);
        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }

        path.addFirst(start);
    }


    // Iterative version:
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
