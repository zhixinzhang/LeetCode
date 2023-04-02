package Company.Google.Design;

import java.util.*;

/**
 * Created by zhang on 2018/8/1.
 */
public class _676_ImplementMagicDictionary_MAP {
    static HashMap<Integer,Set<String>> hm = new HashMap<>();
    public static void main(String[] args){
        search("abe");
    }

    public static List<String> search(String word) {
        Set<String> res = new HashSet<>();
        res.add("abc");
        res.add("abd");
        List<String> l = new ArrayList<>();
        if(res.size() == 0) return l;
        for(String s : res){
            int count = 0;
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) != s.charAt(i))
                    count++;
                if(count >= 2)
                    break;
            }
            if(count == 1)
                l.add(s);
        }
        return l;
    }

    static class Trie{
        char letter;
        Trie[] children;
        boolean flag;
        Trie(char letter){
            this.letter = letter;
            flag = false;
            children = new Trie[26];
        }
        public Trie() {
            flag = false;
            children = new Trie[26];
        }
    }
    static Trie root = new Trie();

    public static void buildDict(String[] dict) {
        Trie cur;
        for (String word : dict){
            cur = root;
            for (int i = 0; i<word.length(); i++){
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new Trie(c);
                cur = cur.children[c-'a'];
            }
            cur.flag = true;
        }
    }
    public static boolean find (String word){
        return helper(root, word, 0, 0);
    }
    public static boolean helper(Trie root, String word, int count, int index) {
        boolean ret = false;
        if (index == word.length()){
            if (root.flag == false || count == 0)
                return ret;
            else
                return true;
        }

        for (int i = 0; i < 26; i++) {
            int countcur = count;
            int indexcur = index;
            if (root.children[i] != null) {
                if (root.children[i].letter != word.charAt(indexcur)) {
                    countcur++;
                    if (countcur > 1) {
                        continue;
                    }
                }
                ret = ret || helper(root.children[i], word, countcur, ++indexcur);
                if (ret) {
                    return true;
                }
            }

        }
        return ret;
    }
}
