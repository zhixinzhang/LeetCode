package Company.Google.Array;

import java.util.*;

/**
 * Created by zhang on 2018/6/23.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs
 * are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 *
 * https://leetcode.com/problems/sentence-similarity/discuss/109633/Java-Super-Clean-Code-(Similarity-I-and-II)
 */
public class _737_SentenceSimilarityII_Graph_UF_DFS_BFS {

    public boolean areSentencesSimilarTwo(String[] a, String[] b, String[][] pairs) {
        if (a.length != b.length) return false;
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (String[] s : pairs){
            if (!graph.containsKey(s[0])) graph.put(s[0], new ArrayList<>());
            if (!graph.containsKey(s[1])) graph.put(s[1], new ArrayList<>());
            graph.get(s[0]).add(s[1]);
            graph.get(s[1]).add(s[0]);
        }
        // bfs
        if (!bfs(graph,a,b))return false;
        if (ufDetect(pairs,a,b)) return false;
        if(!dfs(a,b,pairs)) return false;

//        if (!dfs(words1[i], words2[i], pairInfo, new HashSet<>())) return false;    //Search the graph.
        return true;
    }

    public boolean bfs(HashMap<String, List<String>> graph, String[] a, String[] b){
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        int index = 0;
        for (String s : a){
            q.add(s);
            hs.add(s);
            while (!q.isEmpty()){
                int size = q.size();
              a:  for (int i = 0; i<size; i++ ){
                    String curS = q.poll();
                    if (!graph.containsKey(curS))
                        return false;
                    List<String> curSList = graph.get(curS);
                    for (int j = 0; j < curSList.size(); j++){
                        if (curSList.get(i).equals(b[index])){
                            index++;
                            break a;
                        }
                        if (!hs.contains(curSList.get(j))){
                            q.offer(curSList.get(j));
                            hs.add(curSList.get(j));
                        }
                    }
                }
                q.clear();
                hs.clear();
                if (q.isEmpty())
                    return false;
            }
        }
        return true;
    }

    public boolean ufDetect(String[][] pairs, String[] a, String[] b){
        // a b c    d e f
        // a - g  d - g  b - e  c - f
        if(a.length != b.length)    return false;
        HashMap<String, String> hm = new HashMap<>();
        for (String[] p : pairs){
            if (!hm.containsKey(p[0])) hm.put(p[0],p[0]);
            if (!hm.containsKey(p[1])) hm.put(p[1],p[1]);
            setParent(hm, p[0],p[1]);
        }
        for(int i=0;i<a.length;i++){

            String word1 = a[i];
            String word2 = b[i];

            String parent1 = getParent(word1,hm);
            String parent2 = getParent(word2,hm);

            if(!parent1.equals(parent2))
                return false;

        }
        return true;
    }
    public void setParent(HashMap<String, String> hm, String a, String b){
        String pA = getParent(a,hm);
        String pB = getParent(b,hm);
        hm.put(pA,pB);
    }
    public String getParent(String word, HashMap<String, String> map){
        if(!map.containsKey(word))
            return word;

        while(!word.equals(map.get(word)))
            word = map.get(word);
        return word;
    }


    public boolean dfs(String[] words1, String[] words2, String[][] pairs){
        if (words1.length != words2.length)
            return false;
        HashMap<String, Set<String>> pairInfo = new HashMap<>();
        for (String[] pair : pairs){
            if (!pairInfo.containsKey(pair[0])){
                pairInfo.put(pair[0],new HashSet<>());
            }
            if (!pairInfo.containsKey(pair[1])) {
                pairInfo.put(pair[1], new HashSet<>());
            }
            pairInfo.get(pair[0]).add(pair[1]);
            pairInfo.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i<words1.length; i++){
            if (words1[i].equals(words2[i])) continue;
            if (!pairInfo.containsKey(words1[i]))   return false;
            if (!dfsSolu(words1[i],words2[i], pairInfo, new HashSet<>()))return false;    //search graph
        }
        return true;
    }

    public boolean dfsSolu(String source, String target, Map<String, Set<String>> pairInfo, Set<String> visited){
        if (pairInfo.get(source).contains(target)) return true;
        visited.add(source);
        for (String next : pairInfo.get(source)){
            if (!visited.contains(next) && dfsSolu(next,target,pairInfo, visited))
                return true;
        }
        return false;
    }
}
