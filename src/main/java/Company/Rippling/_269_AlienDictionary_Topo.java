package Company.Rippling;
import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/solutions/2426020/topological-sort-95-faster-o-v-e-time-o-v-n-space/
 * 
 * We can solve the problem using topological sort.

The steps are as follows:

Initialise Graph(Adjacency List) and in degree map
Build the indegree map and the adjacency list in the following way: Take two words. Check for each character of the two words, 
if there's a mismatch between the characters, that means character of the second word is a child of the character of the first word. 
For example, if the first word is bc and second word is ba , c is parent of a. Increase degree of child as well in indegree map
Find all sources i.e., all vertices with 0 in-degrees
For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
Edge case 1: If the second word is a substring of the first word, return empty string.
Edge case 2: If sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore,
 we will not be able to find the correct ordering of the characters
 * 
*/
public class _269_AlienDictionary_Topo {
    public String alienOrder(String[] words) {
        if(words.length==0)
            return "";
        Map<Character,Integer>inDegree=new HashMap<>();
        Map<Character,List<Character>>graph=new HashMap<>();
		//a. Initialise adjacency list and in degree map
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<Character>());
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i], w2 = words[i + 1];
            //Checks if str1 starts wtih str2
            if (w1.length() > w2.length() && w1 .startsWith(w2)) {
                return "";
            }
			//b. Build the graph and in degree map
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) { // if the two characters are different
                  graph.get(parent).add(child); // put the child into it's parent's list
                  inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                  break; // only the first different character between the two words will help us find the order
                }
            }
        }
            // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
            sources.add(entry.getKey());
        }
        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
          Character vertex = sources.poll();
          sortedOrder.append(vertex);
          List<Character> children = graph.get(vertex); // get the node's children to decrement their in-degrees
          for (Character child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            if (inDegree.get(child) == 0)
              sources.add(child);
          }
        }

        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore, we
        // will not be able to find the correct ordering of the characters
        if (sortedOrder.length() != inDegree.size())
          return "";

        return sortedOrder.toString();
    }
}
