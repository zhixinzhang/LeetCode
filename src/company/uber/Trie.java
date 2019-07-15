//package company.uber;
//
//import java.util.List;
//
///**
// * Created by zhang on 2018/9/7.
// */
//public class Trie {
//    TrieNode root;
//    public void buildTrie(List<String> words){
//        root = new TrieNode();
//        for (String s : words){
//            TrieNode cur = root;
//            for (int i = 0; i < s.length(); i++){
//                int idx = s.charAt(i) - 'a';
//                if (cur.children[idx] == null)
//                    cur.children[idx] = new TrieNode();
//                if (i == s.length() - 1)
//                    cur.children[idx].isWord = true;
//                cur = cur.children[idx];
//            }
//        }
//    }
//}
//
//class TrieNode{
//    boolean isWord;
//    TrieNode[] children;
//    TrieNode(){
//        children = new TrieNode[26];
//    }
//}
