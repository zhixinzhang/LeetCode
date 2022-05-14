package DataStructure.Array;
import java.util.*;

public class _720_LongestWordinDictionary_Trie_BFS_DFS{

	 class TrieNode{
        TrieNode[] children;
        boolean isWord;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i = 0; i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
            node.word = word;
        }
        
        public String findLongestWord(){
            String result = null;
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i< size;i++){
                    TrieNode node = queue.poll();
                    for(int j = 25;j>=0;j--){
                        if(node.children[j] !=null && node.children[j].isWord){
                            result = node.children[j].word;
                            queue.offer(node.children[j]);
                        }
                    }
                }
            }
            return result;
        }
    }
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){           //build trie tree
            trie.insert(word);
        }
        return trie.findLongestWord();
    }
}