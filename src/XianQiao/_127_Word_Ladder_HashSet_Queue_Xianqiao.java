package XianQiao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 3/29/20 19:18
 */
public class _127_Word_Ladder_HashSet_Queue_Xianqiao {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList){
            set.add(word);
        }
        if (!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            //每次for循环以后才会重新计算q的size，这使得每次都循环一个phrase，全部结束后才会循环下一个phase
            for (int i = 0; i < size; i++){
                String current_word = queue.poll();
                char[] word_chars = current_word.toCharArray();
                for (int j = 0; j < word_chars.length; j++){
                    char original_char = word_chars[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        if (word_chars[j] == c) continue;
                        word_chars[j] = c;
                        String new_word = String.valueOf(word_chars);
                        //character to string--> String.valueOf(char)
                        if (new_word.equals(endWord)) return level + 1;
                        if (set.contains(new_word)){
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    word_chars[j] = original_char;
                }
            }
            level++;
        }
        return 0;
    }
}
