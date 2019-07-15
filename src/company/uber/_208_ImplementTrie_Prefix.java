package company.uber;

/**
 * Created by zhang on 2018/9/17.
 *
 * Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 */
// follow up 多一个delete（string s） boolean
class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode() {}
    public TrieNode(char c){
        this.children = new TrieNode[26];
        this.val = c;
    }
}

class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
        root.val = ' ';
    }
    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
                cur.children[c - 'a'] = new TrieNode(c);
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
    // 2 step
    // app , apple
    public void delete(String word){

    }
}
public class _208_ImplementTrie_Prefix {
}
