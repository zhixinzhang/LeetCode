package Company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/10/19
 * Time: 12:03 AM
 * Description:
 *
 * 最好的解法是 两头 bfs
 */


public class _126_WordLadder2_BFS {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(beginWord == endWord) return ans;
        HashSet<String> cache = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String s : wordList) cache.add(s);
        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        boolean find = false;
        while(!q.isEmpty()){
            if(find)
                break;
            int size = q.size();
            for(int i = 0; i < size; i++){
                List<String> curPath = q.poll();
                String startW = curPath.get(curPath.size() - 1);
                List<String> next = match(startW, cache);
                if(next.size() != 0){
                    for (String s : next){
                        curPath.add(s);
                        q.add(curPath);
                        if(s == endWord){
                            find = true;
                            ans.add(curPath);
                        }
                    }
                }

            }
        }
        return ans;
    }

    public List<String> match(String word, HashSet<String> cache){
        char[] cs = word.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            for(int j = 1; j < 26; j++){
                cs[i] += 1;
                String newWord = new String(cs);
                if (cache.contains(newWord))
                    res.add(newWord);

            }
            cs[i] = c;
        }
        return res;
    }
}
