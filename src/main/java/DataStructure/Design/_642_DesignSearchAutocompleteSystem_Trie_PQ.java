package DataStructure.Design;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/14/19
 * Time: 5:50 PM
 * Description:
 */


public class _642_DesignSearchAutocompleteSystem_Trie_PQ {

    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void insert(String s, int nums){
            TrieNode cur = root;

            for (char c : s.toCharArray()){
                int index = c == ' ' ? 26 : c - 'a';
                if (cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                    cur.children[index].words.putIfAbsent(nums,new ArrayList<>());
                    cur.children[index].words.get(nums).add(s);
                    cur = cur.children[index];
                }
            }
        }
        HashMap<Integer, List<String>> search(String s){
            HashMap<Integer, List<String>> hm = new HashMap<>();
            int i = 0;
            for (char c : s.toCharArray()){
                int index = c == ' ' ? 26 : c - 'a';
                if (root.children[index] != null){
                    if (i == s.length()-1)
                        return root.words;
                    i++;
                    root = root.children[index];
                }
            }
            return hm;
        }

    }
    class TrieNode{
        TrieNode[] children;
        HashMap<Integer, List<String>> words;
        TrieNode(){
            children = new TrieNode[27];
            words = new HashMap<>();
        }
    }
    String s = "";
    Trie trie;
    public _642_DesignSearchAutocompleteSystem_Trie_PQ(String[] sentences, int[] times) {
        trie = new Trie();
        int i = 0;
        for (String s : sentences){
            trie.insert(s, times[i]);
            i++;
        }
    }

    public List<String> input(char c) {
        s += c;
        List<String> res = new ArrayList<>();
        HashMap<Integer, List<String>> hm = trie.search(s);
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (a,b)->(b-a));
        for (int i : hm.keySet()){
            pq.add(i);
            if (pq.size() > 3)
                pq.poll();
        }
        while (pq.isEmpty()){
//            int num = pq.poll();
            List<String> curStrings = hm.get(pq.poll());
            Collections.sort(curStrings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            if (curStrings.size() + res.size() <= 3)
                res.addAll(curStrings);
            else {
                res.addAll(curStrings.subList(0, 3 - res.size() - 1));
                break;
            }
        }
        return res;
    }
}
