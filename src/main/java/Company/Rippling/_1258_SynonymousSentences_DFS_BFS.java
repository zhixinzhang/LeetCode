package Company.Rippling;
import java.util.*;

/**
 * 
 * 
DFS:
build graph from the synonyms
flatten each word with all of the possible synonyms (except the word itself)
dfs to get the permutation

UF :
Union and find: for every synonym pair, union two words (always choose the word that is lexicographically smaller to be the parent).
Build a sets based on each parent.
Perform DFS to find all combinations.
Sort all combinations.

BFS : 
 * 
*/
public class _1258_SynonymousSentences_DFS_BFS {
    // DFS : 
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ans = new ArrayList<>();
        if (text.isEmpty()) {
            return ans;
        }

        // build graph
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms){
            graph.putIfAbsent(pair.get(0), new HashSet<>());
            graph.get(pair.get(0)).add(pair.get(1));
            graph.putIfAbsent(pair.get(1), new HashSet<>());
            graph.get(pair.get(1)).add(pair.get(0));
        }

        // 2. flatten each word by traversing the graph to find all of synonyms
        Map<String, Set<String>> syns = new HashMap<>();
        for (String key : graph.keySet()){
            if (!syns.containsKey(key)){
                Set<String> used = new HashSet<>();
                flatten(graph, key, used);
                for (String syn : used){
                    syns.put(syn, used);
                }
            }
        }

        // 3. build the permutations
        bt(ans, text.split(" "), 0, syns);
        Collections.sort(ans);
        return ans;
    
    }

    private void flatten(Map<String, Set<String>> graph, String start, Set<String> used){
        used.add(start);
        if (graph.containsKey(start)){
            for (String syn : graph.get(start)){
                if (!used.contains(syn)) {
                    flatten(graph, syn, used);
                }
            }
        }
    }

    private void bt(List<String> ans, String[] words, int index, Map<String, Set<String>> syns) {
        if (index == words.length) {
            ans.add(String.join(" ", words));
            return;
        } else if (syns.containsKey(words[index])){
            for (String syn : syns.get(words[index])){
                words[index] = syn;
                bt(ans, words, index + 1, syns);
            }
        } else {
            bt(ans, words, index + 1, syns);
        }

    }

    // BFS
    public List<String> generateSentences_BFS(List<List<String>> synonyms, String text) {
        if (text == null || text.length() == 0) {
            return Collections.emptyList();
        }
        
        if (synonyms == null || synonyms.size() == 0) {
            return Collections.singletonList(text);
        }
        
        Map<String, List<String>> graph = buildSynonymsGraph(synonyms);
        
        Queue<String> queue = new LinkedList();
        queue.offer(text);
        
        Set<String> processedTexts = new TreeSet();
        
        while (!queue.isEmpty()) {
            String str = queue.poll();
            
            processedTexts.add(str);
            
            List<String> words = Arrays.asList(str.split("\\s"));
            
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                
                if (!graph.containsKey(word)) continue;
                
                for (String synonymsWord: graph.get(word)) {
                    words.set(i, synonymsWord);
                    String synonymsSentence = String.join(" ", words);
                    if (!processedTexts.contains(synonymsSentence)) {
                        queue.offer(synonymsSentence);
                    }
                }
            }
        }
        
        return new ArrayList(processedTexts);
    }
    
    private Map<String, List<String>> buildSynonymsGraph(List<List<String>> synonyms) {
        Map<String, List<String>> graph = new HashMap<>();
        
        for (List<String> pair : synonyms) {
            String w1 = pair.get(0), w2 = pair.get(1);
            graph.computeIfAbsent(w1, k -> new LinkedList<>()).add(w2);
            graph.computeIfAbsent(w2, k -> new LinkedList<>()).add(w1);
        }
        
        return graph;
    }
}
