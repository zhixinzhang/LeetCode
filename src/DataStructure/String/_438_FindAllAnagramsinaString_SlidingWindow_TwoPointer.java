package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/2/2021 12:54 AM
 * <p>
 * Description:
 * Key Point:
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
 */

public class _438_FindAllAnagramsinaString_SlidingWindow_TwoPointer {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return ans;
        }
        // p "abc"
        int count = p.length();
        int[] chars = new int[26];
        for (char c : p.toCharArray()){
            chars[c - 'a']++;
        }
        // chars -> [1, 1, 1, 0 ......]
        int start = 0, end = 0;
        while(end < s.length()){
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (chars[s.charAt(end) - 'a'] >= 1) {
                count--;
            }

            chars[s.charAt(end) - 'a']--;
            end++;

            if (count == 0) {
                ans.add(start);
            }

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (end - start == p.length()){
                if (chars[s.charAt(start) - 'a'] >= 0) {
                    count++;
                }

                chars[s.charAt(start) - 'a']++;
                start++;
            }

        }

        return ans;
    }

    public static void main(String[] args){
        findAnagrams("cbaebabacd", "abc");
    }
}
