package DataStructure.Array;


/**
 * https://leetcode.com/problems/longest-word-with-all-prefixes/solutions/1207550/clean-java/
 * Template Trie problem, we first save all the words into trie
then we search every word, if all words' prefix can be found in trie, we save the longer or same length lexicographically smallest one
 * 
 * 
*/
class Trie {
    Trie[] children = new Trie[128];
    boolean isWord;
}

public class _1858_LongestWordWithAllPrefixes_Trie {
    Trie root = new Trie();
    String res = "";
    public String longestWord(String[] words) {
        for (String word : words) addWord(word);
        for (String word : words) searchPrefix(word);
        return res;
    }
    
    private void searchPrefix(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.children[c];
            if (!cur.isWord) return;
        }
        if (res.length() < word.length() ||
            res.length() == word.length() && res.compareTo(word) > 0) res = word;
    }
    
    private void addWord(String word) {
        Trie cur = root;
        for(char c : word.toCharArray()) {
            if (cur.children[c] == null) cur.children[c] = new Trie();
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
}
