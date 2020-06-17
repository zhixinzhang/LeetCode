package XianQiao;

import javax.swing.*;
import java.util.*;

/**
 * @Author: Xianqiao
 * @Date: 3/29/20 22:07
 */
public class _126_Word_LadderII_Queue_BFS {
    public class Pair {
        String word;
        List<String> path;
        public Pair(String word, List<String> path) {
            this.word = word;
            this.path = path;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, new ArrayList<String>()));
        //queue.add(new Pair());
        HashSet<String> set = new HashSet<>();
        for (String word : wordList){
            set.add(word);
        }
        if (!set.contains(endWord)){
            return 0;
        }
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(flag){
                for (int i = 0; i < size; i++){
                    String current_word = queue.poll();
                    //word = queue.poll()
                    char[] word_chars = current_word.toCharArray();
                    for (int j = 0; j < word_chars.length; j++){
                        char original_char = word_chars[j];
                        for (char c = 'a'; c <= 'z'; c++){
                            if (word_chars[j] == c) continue;
                            word_chars[j] = c;
                            String new_word = String.valueOf(word_chars);
                            if (new_word.equals(endWord)){
                                //add endWord to path
                                flag = false;
                            };
                            if (set.contains(new_word)){
                                queue.offer(new_word);
                                set.remove(new_word);
                                //add new_word to path
                            }
                        }
                        word_chars[j] = original_char;
                    }
                }
                level++;
            }
        }
        return 0;
    }
}
