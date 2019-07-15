package google.Tree;

import google.TreeNode;

/**
 * Created by zhang on 2018/6/3.
 * Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 */
//_208_ImplementTrie_PrefixTree
class TrieNode{
    char val;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    TrieNode(char c){
        this.val = c;
    }
    TrieNode(){
    }
}

public class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == "") return;
        TrieNode ws = root;
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return true;
        TrieNode ws = root;
        for (int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if (null == ws.children[c - 'a']){
                return false;
            }else{
                ws = ws.children[c - 'a'];
            }
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
