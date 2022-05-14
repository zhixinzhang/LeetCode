package DataStructure.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/16/19
 * Time: 12:59 PM
 * Description:
 *
 * https://leetcode.com/problems/find-and-replace-pattern/
 * each time hashmap store the a->b and b->a
 * if two key point to one value , skip the sting
 * ex a->b and c->b
 *
 * time complexity -> O(average(len(word)) * nums(word))
 * space -> hashmap -> O(average(len (word))
 */


public class _890_FindandReplacePattern_HM {
    public static void main(String[] args){
        findAndReplacePattern(new String[]{"ao"}, "ya");
    }


    public List<String> findAndReplacePattern_right(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
            if (match(word, pattern))
                ans.add(word);
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> M = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p: M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
    // ao -> ya
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0 || pattern == null || pattern.length() == 0)
            return res;
        a: for(String w : words){
            HashMap<Character, Character> cache = new HashMap<>();
            if(w.length() != pattern.length())  continue;
            for(int i = 0; i<w.length(); i++){
                char cw = w.charAt(i);
                char cp = pattern.charAt(i);
                if(cache.containsKey(cw) && cache.get(cw) != cp)
                    continue a;
                if(cache.containsKey(cp) && cache.get(cp) != cw)
                    continue a;
                cache.put(cw, cp);
                cache.put(cp, cw);
            }
            res.add(w);
        }
        return res;
    }


    // 假设只有 lower  letter
    public List<String> findAndReplacePattern_int(String[] words, String pattern) {
        if(words == null || words.length == 0)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int[] chars = new int[26];
        for(char c : pattern.toCharArray()){
            chars[c - 'a']++;
        }
        for(String s : words){
            if(match(s, chars))
                ans.add(s);
        }
        return ans;
    }

    public boolean match(String word, int[] chars){
        int[] wordS = new int[26];
        for(char c : word.toCharArray()){
            wordS[c - 'a'] ++;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(wordS[i] != 0)
                sb1.append(wordS[i]);
            if(chars[i] != 0)
                sb2.append(wordS[i]);
        }
        if(sb1.toString().equals(sb2.toString()))
            return true;
        else
            return false;
    }
}
