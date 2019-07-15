package DataStructure.String;
import java.util.*;
/**Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.*/

public class _409_LongestPalindrome_HashSet{
    public int longestPalindrome(String s) {

        HashSet<Character> hs = new HashSet<>();
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                result = result + 2;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (hs.size() != 0) result++;

        return result;
    }
}