package DataStructure.String;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 11:24 AM
 * Description:
 */


public class _966_VowelSpellchecker_Map_Trie {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }


    class Solution {

        TrieNode root = new TrieNode();
        public String[] spellchecker(String[] wordlist, String[] queries) {
            String[] res = new String[queries.length];
            for (String word : wordlist) {
                insert(word);
            }
            for (int i = 0; i < queries.length; i++) {
                res[i] = query(queries[i]);
            }
            return res;
        }

        private void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    if (node.children[0] == null) {
                        node.children[0] = new TrieNode();
                    }
                    node = node.children[0];
                } else {
                    c = Character.toLowerCase(c);
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
            }
            node.isEnd = true;
            node.list.add(word); // Store all words at the end node.
        }

        private String query(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    if (node.children[0] == null) return "";
                    node = node.children[0];
                } else {
                    c = Character.toLowerCase(c);
                    if (node.children[c - 'a'] == null) return "";
                    node = node.children[c - 'a'];
                }
            }
            if (node.isEnd == false) return "";   // If not end, return empty
            if (node.list.contains(word)) return word; // If list contains exactly the same word, return the word.

            String res = findCap(node.list, word); // Search for the first capitalized match
            if (res != "") return res;

            return node.list.get(0); // Return the first one that change vowels
        }

        private String findCap(List<String> list, String word) {
            for (String str : list) {
                if (str.toLowerCase().equals(word.toLowerCase())) return str;
            }
            return "";
        }

    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        List<String> list = new ArrayList<>();
    }
}
