package DataStructure.Trie;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:
 */

public class TrieNode {
    char val;
    boolean isWord;
    public Set<String> prefixString;
    public TrieNode[] trieNodes;

    public TrieNode() {
        prefixString = new HashSet<>();
        trieNodes = new TrieNode[26];
    }

    public TrieNode(char c){
        this.val = c;
        prefixString = new HashSet<>();
        trieNodes = new TrieNode[26];
    }

    public void insert(TrieNode root, String word){
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (root.trieNodes[c - 'a'] == null) {
                root.trieNodes[c - 'a'] = new TrieNode(c);

            }
            if (i == word.length() - 1) {
                root.trieNodes[c - 'a'].isWord = true;
            }
            root.trieNodes[c - 'a'].prefixString.add(word);
            root = root.trieNodes[c - 'a'];
        }
    }

}
