package Company.Rippling;
import java.util.*;

/*
https://www.1point3acres.com/bbs/thread-911199-1-1.html
给一个list of 同义词 和 一个list of sentences， 把相似的sentence group到一起
ie：input: [("main", "primary"), ("main", "important"), ("rating", "score")]
                ["main email" , "secondary email", "primary email", "important email", "performance rating", "performance score"]
      output: [ ["main email", "primary email", "important email"], ["secondary email"], ["performance rating", "performance score"] ]
注意 相似的sen‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌tence是指这个sentence中每个word要么相同要么是同义词，比较的时候只要比较每个word就行了

**/
public class MainSynonymousSentences {
    public static void main(String[] args){
        String[][] syno = new String[][]{
            {"main", "primary"},
            {"main", "important"},
            {"rating", "score"}
        };

        String[] sentences = new String[]{
            "main email" , "secondary email", "primary email", 
            "important email", "performance rating", "performance score"};

        List<List<String>> ans = findSynonymous(syno, sentences);
    }

    static Map<String, String> fathersMap;
    static Map<String, String> relation = new HashMap();
    static Map<String, List<String>> group = new HashMap();
    private static List<List<String>> findSynonymous(String[][] synonymous, String[] sentences){
        List<List<String>> ans = new ArrayList<>();
        fathersMap = new HashMap();

        for (String[] syno : synonymous){
            fathersMap.putIfAbsent(syno[0], syno[0]);
            fathersMap.putIfAbsent(syno[1], syno[1]);
            union(syno[0], syno[1]);
        }

        // build sets find all fathers
        for (String word: fathersMap.keySet()) {
            String par = compressedFind(word);
            relation.put(word, par);
        }

        
        for (String sentence: sentences) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++){
                if (relation.containsKey(words[i])) {
                    words[i] = relation.get(words[i]);
                }
            }

            String newSen = String.join(" ", words);
            group.putIfAbsent(newSen, new ArrayList<>());
            group.get(newSen).add(sentence);
        }


        for (String key : group.keySet()){
            System.out.println(key + "   :   " + group.get(key).toString());
        }
        return ans;
    }

    private static void union (String word1, String word2){
        String p1 = compressedFind(word1);
        String p2 = compressedFind(word2);

        if (!p1.equals(p2)) {
            fathersMap.put(p1, p2);
        }
    }

    private static String compressedFind(String word){
        if (!fathersMap.get(word).equals(word)) {
            fathersMap.put(word, compressedFind(fathersMap.get(word)));
        }

        return fathersMap.get(word);
    }
}

