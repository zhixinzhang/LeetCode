package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/13/19
 * Time: 10:50 PM
 * Description:
 * 一遍过 我很屌
 */


public class _1002_FindCommonCharacters {
    public static void main(String[] args){
        commonChars(new String[]{"bella","label","roller"});
    }
    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0)
            return res;
        int[] cache = new int[26];
        Arrays.fill(cache, Integer.MAX_VALUE);
        for(String a : A){
            int[] cur = new int[26];
            for(char c : a.toCharArray()){
                cur[c-'a']++;
            }

            for(int i = 0; i < 26; i++){
                cache[i] = Math.min(cache[i], cur[i]);
            }
        }
        for(int i = 0; i < 26; i++){
            int count = cache[i];
            String s = String.valueOf((char)('a' + i));
            while (--count >= 0)
                res.add(s);
        }
        return res;
    }
}
