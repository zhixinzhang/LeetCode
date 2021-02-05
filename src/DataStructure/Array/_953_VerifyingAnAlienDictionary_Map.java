package DataStructure.Array;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/verifying-an-alien-dictionary/solution/
 * Key Point:
 */

public class _953_VerifyingAnAlienDictionary_Map {

    public static boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null || order.length() <= 1) {
            return true;
        }

        Map<Character, Integer> cachedOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++){
            cachedOrder.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++){
            String firstWord = words[i];
            String secondWord = words[i + 1] ;

            if(!doVerifyWords(firstWord, secondWord, cachedOrder)){
                return false;
            }
        }

        return true;
    }

    private static boolean doVerifyWords(String firstWord, String secondWord, Map<Character, Integer> cachedOrder){
        int len = Math.min(firstWord.length(), secondWord.length());

        for (int i = 0; i < len; i++){
            char leftChar = firstWord.charAt(i);
            char rightChar = secondWord.charAt(i);
            if(leftChar != rightChar){
                if (cachedOrder.get(leftChar) > cachedOrder.get(rightChar)) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        if (firstWord.length() > secondWord.length())
            return false;
        return true;
    }

    /**Solution 2 : use array*/

    public  static boolean isAlienSorted_Array(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1 == null || word2 == null){
                throw new IllegalArgumentException("we have an invalid word : " +  word1);
            }

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

    // same with previous
    public static boolean isAlienSorted_One(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }

        int[] chars = new int[26];
        for (int i = 0; i < order.length(); i++){
            chars[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++){
            String wordOne = words[i];
            String wordTwo = words[i + 1];
            if (!verify(wordOne, wordTwo, chars)){
                return false;
            }
        }
        return true;
    }

    private static boolean verify(String word1, String word2, int[] chars){
        int len = Math.min(word1.length(), word2.length());

        for (int i = 0; i < len; i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) {
                continue;
            }

            if (chars[c1 - 'a'] < chars[c2 - 'a']) {
                return true;
            } else {
                return false;
            }
        }

        // apple, app
        if ( word1.length() > word2.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args){
//        isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
//        isAlienSorted_One(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        isAlienSorted_One(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
    }
}
