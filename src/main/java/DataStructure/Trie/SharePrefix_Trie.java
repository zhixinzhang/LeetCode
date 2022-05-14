package DataStructure.Trie;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://www.1point3acres.com/bbs/thread-706172-1-1.html
 * Key Point:
 */

public class SharePrefix_Trie {
        public static void findPairs(List<String> strings){
            TrieNode trieNode = new TrieNode();

            for (String word : strings){
                trieNode.insert(trieNode, word);
            }
            HashMap<String, List<String>> map = new HashMap<>();
        }


        public static void main(String[] args){
                String[] words = new String[]{"abbcc", "ab", "abc", "bbc"};
                List<String> c = Arrays.asList(words);
                findPairs(Arrays.asList(words));
        }
}
