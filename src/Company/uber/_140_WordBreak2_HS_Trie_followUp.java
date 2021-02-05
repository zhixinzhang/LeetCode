package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/7.
 */
public class _140_WordBreak2_HS_Trie_followUp {
    //
    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak_DFS("catsandog",wordDict));
    }


    static HashSet<String> wordD = new HashSet<>();
    static List<String> res = new ArrayList<>();
    //TLE 但是思路对 大部分case过了
    public static List<String> wordBreak_DFS(String s, List<String> wordDict) {
        for(String w : wordDict) wordD.add(w);
        dfs(s, 0, new StringBuilder());
        return res;
    }
    public static void dfs(String s, int idx, StringBuilder prev){
        if (idx >= s.length() && prev.length() != 0){
            String resS = prev.toString();
            resS = resS.trim();
            res.add(resS);
            return;
        }
        for (int j = idx; j < s.length();){
            StringBuilder sb = new StringBuilder();
            while (j < s.length()){
                sb.append(s.charAt(j));
                if (wordD.contains(sb.toString())){
                    prev.append(sb).append(" ");
                    dfs(s, j + 1, prev);
                    prev.delete(prev.length() - sb.length()-1, prev.length());
                }
                j++;
            }
        }
    }



    // DFS + memorized  better than trie
    public List<String> wordBreak_DFS_memo(String s, List<String> wordDict) {
        return backtrack(s,wordDict,new HashMap<String, List<String>>());
    }
    // backtrack returns an array including all substrings derived from s.
    public List<String> backtrack(String s, List<String> wordDict, Map<String,List<String>> mem){
        if(mem.containsKey(s)) return mem.get(s);
        List<String> result = new ArrayList<String>();
        for(String word: wordDict)
            if(s.startsWith(word)) {
                String next = s.substring(word.length());
                if(next.length()==0) result.add(word);
                else for(String sub: backtrack(next, wordDict, mem)) result.add(word+" "+sub);
            }
        mem.put(s, result);
        return result;
    }

    /**                 catsanddog
     *
     *
     *         a         c         s       d
     *           n     a         a             o
     *         d          t          n       g
     *                      s      d
     *
     *
     * **/



    public List<String> wordBreak_Trie(String s, List<String> wordDict) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        TrieNode root = new TrieNode();
        int max = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            insert(root, wordDict.get(i));
            max = Math.max(max, wordDict.get(i).length());
        }
        return helper(s, root, map, s.length(), max);
    }
    private List<String> helper(String s, TrieNode root, HashMap<Integer, List<String>> map, int index, int max) {
        if (index < 0) {
            return new LinkedList<String>();
        }
        if (index == 0) {
            List<String> list = new LinkedList<String>();
            list.add("");
            return list;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        List<String> result = new LinkedList<String>();
        for (int i = Math.max(1, index - max + 1); i <= index; i++) {
            String sub = s.substring(i - 1, index);
            TrieNode node = searchPrefix(root, sub);
            if (node != null && node.isEnd) {
                List<String> pre = helper(s, root, map, i - 1, max);
                for (String item : pre) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(item).append(" ").append(sub);
                    result.add(sb.toString().trim());
                }
            }
        }
        map.put(index, result);
        return result;
    }
    class TrieNode {
        TrieNode[] links;
        boolean isEnd;
        TrieNode() {
            links = new TrieNode[26];
            isEnd = false;
        }
    }
    private void insert(TrieNode root, String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (node.links[cur - 'a'] == null) {
                node.links[cur - 'a'] = new TrieNode();
            }
            node = node.links[cur - 'a'];
        }
        node.isEnd = true;
    }
    private TrieNode searchPrefix(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.links[ch - 'a'] == null) {
                return null;
            }
            node = node.links[ch - 'a'];
        }
        return node;
    }
}
