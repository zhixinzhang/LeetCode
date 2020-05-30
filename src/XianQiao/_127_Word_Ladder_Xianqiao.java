package XianQiao;

import java.util.*;

/**
 * @Author: Xianqiao
 * @Date: 3/28/20 21:16
 */
public class _127_Word_Ladder_Xianqiao {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()){
            return -1;
        }
        HashMap<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> dic = new HashSet<>();
        HashSet<String> visited = new HashSet<>(); //HashSet是很好的去重、查重

        for (String s: wordList){
            if (s.length() == beginWord.length()){
                dic.add(s);
            }
        }

        //build graph
        for (String s: wordList){
            graph.putIfAbsent(s, new ArrayList<>());
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0;)
        }
    }
}
