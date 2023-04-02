package Company.Google;

import java.util.HashMap;

/**
 * Created by zhang on 2017/12/2.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        int a = lengthOfLongestSubstring("au");
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
