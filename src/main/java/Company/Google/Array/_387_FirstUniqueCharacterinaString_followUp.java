package Company.Google.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhang on 2018/6/22.
 * 三种方法 最后一种 就便利了一边
 */
public class _387_FirstUniqueCharacterinaString_followUp {
    public int firstUniqChar_HM(String s) {
        if(s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> hm = new HashMap<>();       // char count
        for(int i = 0; i< s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) + 1);

        }
        for(int i = 0; i< s.length(); i++){
            if(hm.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }

    public int firstUniqChar_Array(String s) {
        int[] res = new int[26];
        for(int i = 0; i<s.length(); i++){
            res[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i<s.length(); i++){
            if(res[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;

    }

    public static int firstUniqChar_OnePass(String s) {
        int[] res = new int[26];
        // leetcode  0
        // 27 1 2
        Arrays.fill(res,-1);
        for(int i = 0; i<s.length(); i++){
            if(res[s.charAt(i) - 'a'] == -1){
                res[s.charAt(i) - 'a'] = i;
            }else{
                res[s.charAt(i) - 'a'] = -2;
            }
        }
        // 0 -2 -2 3 4 5 6 7
        //
        int ans = -1;
        for(int i : res){
            if(i > -1){
                if (ans == -1){
                    ans = i;
                }
                ans = Math.min(ans,i);
            }

        }
        return ans;
    }
    public static void main(String[] args){
        firstUniqChar_OnePass("abca");
    }
}
