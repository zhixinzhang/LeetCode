package google;

import java.util.HashMap;

/**
 * Created by zhang on 2017/12/3.
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 For example,
 Given S = “eceba”,
 T is “ece” which its length is 3.
 */
public class _159_LongestSubstringwithAtMostTwoDistinctCharacters_hashmap_slidingwidow {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int i = 0; i<s.length(); i++){
            char curC = s.charAt(i);
            hm.put(curC,hm.getOrDefault(curC, 0) + 1);
            while(hm.size() > 2){
                char c = s.charAt(left);
                if(hm.containsKey(c) && hm.get(c) == 1)
                    hm.remove(c);
                else
                    hm.put(c,hm.get(c) - 1);
                left++;
                if(left == s.length() -1)
                    break;
            }
            res = Math.max(i - left + 1, res);
        }
        return res;
        }
        public  static void main(String[] args){
            lengthOfLongestSubstringTwoDistinct("eceba");
        }
    }
