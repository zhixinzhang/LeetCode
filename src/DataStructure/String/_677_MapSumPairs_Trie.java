package DataStructure.String;
import java.util.*;


public class _677_MapSumPairs_Trie{
	   /** Initialize your data structure here. */
    class TrieNode{
        boolean isEnd;
        int val = 0;
        TrieNode[] children = new TrieNode[26];
    }
    TrieNode root;
    public void MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        if(key == null || key.length() == 0) return;
        TrieNode node = root;
        for(char c : key.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c-'a'] = new TrieNode();   
            }
            node = node.children[c - 'a'];
        }
        node.val = val;
        node.isEnd = true;
    }
    
    public int sum(String prefix) {
        if(prefix == null || prefix.length() == 0) return 0;
        int res = 0;
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c - 'a'] == null)  
                return 0;
            node = node.children[c - 'a'];
        }
        if(node == null) return 0;
        return getValue(node);
    }
    
        private int getValue(TrieNode node) {
        int sum = 0;
        if(node.isEnd) {
            sum += node.val;
        }
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                char c = (char) (i + 'a');
                sum += getValue(node.children[i]);
            }
        }
        return sum;
    }
    
}