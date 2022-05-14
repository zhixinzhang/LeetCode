package DataStructure.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/21/19
 * Time: 1:24 PM
 * Description:
 * https://leetcode.com/problems/shortest-word-distance/
 */


public class _243_ShortestWordDistance_TwoPointer {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0)
            return 0;
        int l1 = -1, l2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            if(cur.equals(word1)){
                l1 = i;
            }else if(cur.equals(word2)){
                l2 = i;
            }
            if(l1 != -1 && l2 != -1)
                res = Math.min(Math.abs(l2 - l1), res);

        }
        return res;
    }
}
