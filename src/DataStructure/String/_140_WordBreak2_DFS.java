package DataStructure.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Created by zhang on 2018/1/19.
 * s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].
 A solution is ["cats and dog", "cat sand dog"].
 */
//O(n^3)
//space(n^3)
public class _140_WordBreak2_DFS {
    public List<String> wordBreak_DP(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> dp = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordDict);
        if(s == null || s.length() <= 1) return new ArrayList<>();
        int len = s.length() + 1;
        List<String> start = new ArrayList<>();
        start.add("");
        dp.put(0, start);
        for(int i = 1; i < len; i++ ){
            dp.put(i, new ArrayList<>());
        }
        for(int i = 1; i < len; i++){
            for(int j = 1; j < i; j++){
                String w = s.substring(j,i);
                if(wordDict.contains(w) && dp.get(j).size() != 0){
                    List<String> temp = dp.get(i);
                    for(String preW : dp.get(j)){
                        preW = preW + " " + w;
                        temp.add(preW.trim());
                    }
                }
            }
        }
        return dp.get(len-1);
    }


    static  HashMap<Integer,List<String>> hm = new HashMap<>();
    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordBreak("catsanddog",wordDict);
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> a = dfs(s,wordDict,0);
        return a;
    }
    private static List<String> dfs(String s, List<String> wordDict, int index){
        if(hm.containsKey(index)){
            return hm.get(index);
        }
        List<String> res = new ArrayList<>();
        if(index == s.length())
            res.add("");

        for (int end = index + 1; end<= s.length(); end++){
            String curS = s.substring(index,end);
            if(wordDict.contains(curS)){
                List<String> list = dfs(s,wordDict,end);
                for(String temp : list){
                    res.add(curS + (temp.equals("")?"":" ") + temp);
                }
            }
        }
        hm.put(index,res);
        return res;
    }
}
