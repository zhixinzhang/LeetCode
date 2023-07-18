package Company.Ebay;

/**
 * Created by zhang on 2017/9/18.
 *  Given "abcabcbb", the answer is "abc", which the length is 3.
 */

import java.util.HashMap;
import java.util.Map;

/** key : two pointer  and  all numbers can be ASCII
 *Time complexity : O(n). Index jjj will iterate nnn times.

Space complexity : O(min(m,n)). Same as the previous approach.
 *
 * */
public class _3_LongestSubstringWithout_SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int start=0, len=0;
        
        // abba
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) 
                    start = map.get(c) + 1;
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }
        
        return len;
    }
}
