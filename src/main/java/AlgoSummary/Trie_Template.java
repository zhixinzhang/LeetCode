package AlgoSummary;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 1:26 PM
 * Description:
 */


public class Trie_Template {
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for (char c : word.toCharArray()){
                int idx = c - 'a';
                if(cur.children[idx] == null)
                    cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.isEndOfWord = true;
            cur.word = word;
        }

        public boolean search(String word){
            TrieNode cur = root;
            for (char c : word.toCharArray()){
                int idx = c - 'a';
                if(cur.children[idx] == null)
                    return false;
                cur = cur.children[idx];
            }
            return cur != null && cur.isEndOfWord;
        }
    }


    int size = 26;
    class TrieNode{
        TrieNode[] children;
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        String word;
        TrieNode(){
            children = new TrieNode[size];
            isEndOfWord = false;
        }
    }
}
