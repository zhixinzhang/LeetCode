package DataStructure.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luke Zhang
 * @Date 2021-04-26 17:24
 */
public class _211_DesignAddAndSearchWordsDataStructure_Trie {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isWord;
        }
        if (chs[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }

    // my solution :

//    class TrieNode {
//        boolean isWord;
//        char val;
//        Map<Character, TrieNode> children = new HashMap<>();
//
//        public TrieNode(){
//        }
//
//        public TrieNode(Character c){
//            this.val = c;
//            this.isWord = false;
//        }
//    }
//
//    TrieNode trieNodeRoot;
//    public _211_DesignAddAndSearchWordsDataStructure_Trie() {
//        trieNodeRoot = new TrieNode();
//    }
//
//    public void addWord(String word) {
//        TrieNode currentNode = trieNodeRoot;
//        for (char c : word.toCharArray()){
//            TrieNode node = new TrieNode(c);
//            if (!currentNode.children.containsKey(c)) {
//                currentNode.children.put(c, node);
//            }
//            currentNode = currentNode.children.get(c);
//        }
//
//        currentNode.isWord = true;
//    }
//
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        TrieNode curNode = trieNodeRoot;
//        return dfs(chars, 0, false, curNode);
//    }
//
//    private boolean dfs(char[] chars, int index, boolean prevDot, TrieNode curNode){
//        if (index == chars.length)
//            return true;
//        char curChar = chars[index];
//
//        boolean b1;
//        if (!prevDot && curNode.children.containsKey(curChar)){
//            return dfs(chars, index + 1, false, curNode.children.get(curChar));
//        } else if (curChar != '.' && !curNode.children.containsKey(curChar)){
//            return false;
//        } else if (curChar == '.'){
//            for (char c : curNode.children.keySet()){
//                b1 = dfs(chars, index + 1, true, curNode.children.get(c));
//                if (b1) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
