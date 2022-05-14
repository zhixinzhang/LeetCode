package DataStructure.String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/5/1.
 */
public class _395_LongestSubstringwithAtLeastKRepeatingCharacters_DivideAndConquer {
    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i<s.length(); i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        Character splitC = null;
        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            if(entry.getValue()<k){
                splitC = entry.getKey();
            }
        }
        if (splitC == null)
            return s.length();


        int maxlen = 0;
        String[] splits = s.split(""+splitC);
        for(String str: splits){
            maxlen = Math.max(maxlen, longestSubstring(str,k));
        }
        return maxlen;
    }

    public static void main(String[] args){
        longestSubstring("ababacb",3);
    }

}
