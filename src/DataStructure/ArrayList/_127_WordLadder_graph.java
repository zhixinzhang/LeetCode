package DataStructure.ArrayList;

import java.util.*;

/**
 * Created by zhang on 2017/10/29.
 * Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 */
/**实际是一个map  用bfs 找到最短的路径  最快的方法是 从开始和结束点一起出发找
 * 用queue
 *
 *
 * 2019/5/16  这题对我来说 就是秒杀
 * */
/*我写的方法 time limit 只从起点开始找 29/39 test case 已经注释掉*/
public class _127_WordLadder_graph {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length())
            return 0;
        if(beginWord.equals(endWord))
            return 1;
        HashSet<String> set = new HashSet<>();
        HashSet<String> cache = new HashSet<>();
        for(String w : wordList)
            set.add(w);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        cache.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                String curWord = q.poll();
                List<String> nextLevel = findMatch(curWord, set, cache);
                for(String s : nextLevel){
                    if(s.equals(endWord)){
                        return level;
                    }else{
                        q.add(s);
                        cache.add(s);
                    }
                }

            }
        }
        return 0;
    }

    private List<String> findMatch(String curWord, HashSet<String> set, HashSet<String> cache){
        List<String> ans = new ArrayList<>();
        char[] cs = curWord.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char temp = cs[i];
            for(char a = 'a'; a <='z'; a++){
                cs[i] = a;
                String newWord = new String(cs);
                if(set.contains(newWord) && !cache.contains(newWord))
                    ans.add(newWord);
            }
            cs[i] = temp;
        }
        return ans;
    }

    public static void main(String[] args){
        // teach peach peace place
        List<String> wordList  = new ArrayList<>();
        wordList.add("peale");
        wordList.add("wilts");
        wordList.add("place");
        wordList.add("fetch");
        wordList.add("purer");
        wordList.add("pooch");

        wordList.add("peace");
        wordList.add("poach");
        wordList.add("berra");
        wordList.add("teach");
        wordList.add("rheum");
        wordList.add("peach");
//        int a =ladderLength("teach","place",wordList);
        int c = 0;
    }
}
