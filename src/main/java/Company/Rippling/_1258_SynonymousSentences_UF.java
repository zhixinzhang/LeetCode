package Company.Rippling;
import java.util.*;

public class _1258_SynonymousSentences_UF {
    public static void main(String[] args){
        List<List<String>> synonyms = new ArrayList<>();
        synonyms.add(Arrays.asList(new String[]{"happy","joy"}));
        synonyms.add(Arrays.asList(new String[]{"sad","sorrow"}));
        synonyms.add(Arrays.asList(new String[]{"joy","cheerful"}));

        String text = "I am happy today but was sad yesterday";
        generateSentences_UF(synonyms, text);
    }
    // Union Finds
    static Map<String, String> parent = new HashMap();
    static Map<String, List<String>> sets = new HashMap();

    public static List<String> generateSentences_UF(List<List<String>> synonyms, String text) {
        List<String> res = new ArrayList();
        
        // union find
        for (List<String> pair : synonyms) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            String par1 = find(word1);
            String par2 = find(word2);
            if (par1.equals(par2)) continue;
            if (par1.compareTo(par2) < 0) 
                parent.put(par2, par1);
            else 
                parent.put(par1, par2);
        }
        
        // build sets
        for (Map.Entry entry: parent.entrySet()) {
            String word = (String)entry.getKey();
            String par = find(word);
            if (!sets.containsKey(par)) sets.put(par, new ArrayList());
            sets.get(par).add(word);
        }
        
        // find combinations
        String[] texts = text.split(" ");
        String[] comb = new String[texts.length];
        findCombination(text.split(" "), 0, comb, res);
        Collections.sort(res, (a, b) -> a.compareTo(b));
        return res;
    }
    
    private static String find(String word) {
        if (!parent.containsKey(word)) {
            parent.put(word, word);
            return word;
        }
        if (!parent.get(word).equals(word)) {
            parent.put(word, find(parent.get(word)));
        }
        return parent.get(word);
    }
    
    private static void findCombination(String[] texts, int index, String[] comb, List<String> res) {
        if (index == texts.length) {
            res.add(String.join(" ", comb));
            return;
        }
        
        if (!parent.containsKey(texts[index])) {
            comb[index] = texts[index];
            findCombination(texts, index + 1, comb, res);
        } else {
            String par = find(texts[index]);
            List<String> equalwords = sets.get(par);
            for (String equalword : equalwords) {
                comb[index] = equalword;
                findCombination(texts, index + 1, comb, res);
            }
        }
    }


}
