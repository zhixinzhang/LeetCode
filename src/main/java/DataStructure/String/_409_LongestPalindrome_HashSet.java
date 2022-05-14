package DataStructure.String;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:
 */

public class _409_LongestPalindrome_HashSet {


    // use set, remove when we already have that character
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                ans += 2;
            } else {
                set.add(s.charAt(i));
            }
        }

        return !set.isEmpty() ? ++ans : ans;
    }


}
