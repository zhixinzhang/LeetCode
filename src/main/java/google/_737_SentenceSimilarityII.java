package google;

import java.util.HashMap;
import java.util.Map;
//  dfs   graph
public class _737_SentenceSimilarityII{
    public static void main(String[] args){
        String[] words= {"great","acting","skills"};
        String[] words2 = {"fine","drama","talent"};
        String[][] pairs = {{"great","good"},{"fine", "good"},{"drama","acting"},{"skills","talent"}};
        boolean a = areSentencesSimilarTwo(words,words2,pairs);
        int c = 0;
    }
    public static boolean areSentencesSimilarTwo(String[] a, String[] b, String[][] pairs) {
        if (a.length != b.length) return false;
        Map<String, String> m = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(m, p[0]);
            String parent2 = find(m, p[1]);
            if (!parent1.equals(parent2)){
                m.put(parent1, parent2);
            }
        }

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]) && !find(m, a[i]).equals(find(m, b[i]))) return false;

        return true;
    }

    private static String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
}

// public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        
//         if(words1.length!=words2.length)
//             return false;
        
//         Map<String,String> map = new HashMap<String,String>();
        
//         for(String[] pair : pairs){
            
//             String word1 = pair[0];
//             String word2 = pair[1];
            
//             if(!map.containsKey(word1))
//                 map.put(word1,word1);
//             if(!map.containsKey(word2))
//                 map.put(word2,word2);
            
//             setParent(map,word1,word2);
            
//         }
        
//         for(int i=0;i<words1.length;i++){
            
//             String word1 = words1[i];
//             String word2 = words2[i];
            
//             String parent1 = getParent(word1,map);
//             String parent2 = getParent(word2,map);
            
//             if(!parent1.equals(parent2))
//                 return false;
     
//         }
//         return true;
        
        
//     }
    
//     public String getParent(String word,Map<String,String> map){
        
//         if(!map.containsKey(word))
//             return word;
        
//         while(word!=map.get(word))
//             word = map.get(word);
//         return word;
  
//     }
    
//     public void setParent(Map<String,String> map,String word1,String word2){
        
//         String p1 = getParent(word1,map);
//         String p2 = getParent(word2,map);
        
//         map.put(p1,p2);
   
//     }