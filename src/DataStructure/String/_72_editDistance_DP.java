package DataStructure.String;
/**
 * Created by zhang on 2017/11/12.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
/** each letter have 3 function  i d r . use tree ds logic
 * this is the recursion tree and find shortest path we use bfs bot dfs
 * head  ---- eat*/
public class _72_editDistance_DP {

}



//    public int minDistance(String word1, String word2) {
//        if (word1 == null || word2 == null)
//            return 0;
//        if (word1.length() == 0 || word2.length() == 0)
//            return word1.length() == 0 ? word2.length():word1.length();
//        int[][] match = new int[word1.length() + 1][word2.length() + 1];
//        for (int i = 0; i <= word1.length(); i++) {
//            match[i][0] = i;
//        }
//        for (int j = 0; j <= word2.length(); j++) {
//            match[0][j] = j;
//        }
//
//        for (int i =  0; i < word1.length(); i++) {
//            for (int j = 0; j < word2.length(); j++) {
//                if (word1.charAt(i) == word2.charAt(j))
//                    match[i + 1][j + 1] = match[i][j];
//                else {
//                    match[i + 1][j + 1] = Math.min(Math.min(match[i][j], match[i][j + 1]), match[i + 1][j]) + 1;
//                }
//            }
//        }
//
//        return match[word1.length()][word2.length()];
////    }
