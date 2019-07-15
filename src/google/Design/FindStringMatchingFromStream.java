package google.Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/7/2.
 *
 * 逆序后建Trie树
 */
class TrieNode{
    char word;
    boolean isWord;
    TrieNode[] child;
    public TrieNode(){
        this.child = new TrieNode[26];
    }
}
class Trie{
    TrieNode root;
    // build trie tree
    Trie(String[] words){
        root = new TrieNode();
        for (String w : words){
            TrieNode cur = root;
            for (char ch : w.toCharArray()){
                int idx = ch - 'a';
                if (cur.child[idx] == null)
                    cur.child[idx] = new TrieNode();
                cur = cur.child[idx];
            }
        }
    }
}
public class FindStringMatchingFromStream {
    public static TrieNode buildTrie(String[] targets){
        TrieNode root = new TrieNode();
        for (String t : targets){
            TrieNode curNode = root;
            for (char c : t.toCharArray()){
                if (curNode.child[c - 'a'] == null){
                    TrieNode tmp = new TrieNode();
                    tmp.word = c;
                    curNode.child[c-'a'] = tmp;
                }
                curNode = curNode.child[c-'a'];
            }
        }
        return root;
    }

    public static List<String> next(String stream, String[] targets){
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(targets);
        return res;
    }
    public static void main(String[] args){
        next("tefabceatt", new String[]{"abc","att","bc","bce","eat"});
    }
}
