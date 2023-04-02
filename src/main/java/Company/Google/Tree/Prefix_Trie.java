package google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/19.
 */

public class Prefix_Trie {
  static   class TrieNode{
        char c;
        TrieNode[] children;
        boolean isEnd;
        TrieNode(char c){
            this.c = c;
            this.isEnd = true;
            children = new TrieNode[26];
        }
        boolean contiansKey(char c){
            if (children[c - 'a'] != null)
                return true;
            else
                return false;
        }
        TrieNode getNode(char c){
            return children[c - 'a'];
        }
        void put(char ch, TrieNode node) {
            children[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }


    public static List<String> solution(String s, TrieNode root){
        if (s == null || s.length() == 0) return null;
        List<String> res = new ArrayList<>();
        TrieNode curNode = root;
        int i = 1;
        TrieNode[] next = root.children;//[null b null]
        while (i<s.length()){ // abcd
            curNode = next[s.charAt(i)];
            next = root.children;
        }
        // cur[null null null d]
        recur(curNode,next,s,res);
        return res;
    }
    public static void recur(TrieNode curNode , TrieNode[] root, String s, List<String> res){
        if (curNode.isEnd){
            res.add(s);
            return;
        }

        // 重点是要删除最后一个字符
         for (int i = 0; i < root.length; i++){
            if (root[i] != null){
                s += root[i].c;
                recur(root[i],root[i].children, s, res);
                s = s.substring(0,s.length()-1);
                int a = 0;
            }
         }
    }


    public static void  main(String[] args){
        TrieNode root = new TrieNode('a');
        root.isEnd = false;
        // abc abd  acd
        root.children[1] = new TrieNode('b');
        root.children[1].children[2] = new TrieNode('c');
        root.children[1].children[3] = new TrieNode('d');
        root.children[1].isEnd = false;
        root.children[2] = new TrieNode('c');
        root.children[2].children[3] = new TrieNode('d');
        root.children[2].isEnd = false;

        solution("a",root);
    }
}
