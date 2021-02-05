package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/13/19
 * Time: 3:51 PM
 * Description:
 *
 * backtracking TLE 即使用了 memo
 * 可以用 Trie
 */


public class _472_ConcatenatedWords_DFS_Trie {
    public static void main(String[] args){
        findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if(words == null || words.length <= 1)
            return ans;
        for(String w : words){
            backtrack(w,w, words, ans, 0, set);
        }
        return ans;
    }
    public static void backtrack(String target,String word, String[] words, List<String> ans, int cut, HashSet<String> set){
        if (set.contains(target) && cut >= 1){
            ans.add(word);
            set.add(word);
            return;
        }

        if("".equals(target)){
            if (word != target && cut >= 2){
                ans.add(word);
                set.add(word);
            }
            return;
        }
        for(String w : words){
            if(target.length() >= w.length() && target.startsWith(w)){
                backtrack(target.substring(w.length()), word, words, ans, cut + 1, set);
            }
        }
    }


    public List<String> findAllConcatenatedWordsInADict_Trie(String[] words) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String word : words) { // construct Trie tree
            if (word.length() == 0) {
                continue;
            }
            addWord(word, root);
        }
        for (String word : words) { // test word is a concatenated word or not
            if (word.length() == 0) {
                continue;
            }
            if (testWord(word.toCharArray(), 0, root, 0)) {
                res.add(word);
            }
        }
        return res;
    }
    public boolean testWord(char[] chars, int index, TrieNode root, int count) { // count means how many words during the search path
        TrieNode cur = root;
        int n = chars.length;
        for (int i = index; i < n; i++) {
            if (cur.sons[chars[i] - 'a'] == null) {
                return false;
            }
            if (cur.sons[chars[i] - 'a'].isEnd) {
                if (i == n - 1) { // no next word, so test count to get result.
                    return count >= 1;
                }
                if (testWord(chars, i + 1, root, count + 1)) {
                    return true;
                }
            }
            cur = cur.sons[chars[i] - 'a'];
        }
        return false;
    }
    public void addWord(String str, TrieNode root) {
        char[] chars = str.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (cur.sons[c - 'a'] == null) {
                cur.sons[c - 'a'] = new TrieNode();
            }
            cur = cur.sons[c - 'a'];
        }
        cur.isEnd = true;
    }
}
class TrieNode {
    TrieNode[] sons;
    boolean isEnd;
    public TrieNode() {
        sons = new TrieNode[26];
    }
}
