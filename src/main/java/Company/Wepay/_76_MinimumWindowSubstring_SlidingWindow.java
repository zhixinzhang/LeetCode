package Company.Wepay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/4/2021 11:51 PM
 * <p>
 * Description: https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-%2B-HashMap
 * Similar task :
 * Key Point:
 * Time Complexity: O(|S| + |T|)O(∣S∣+∣T∣)
 * Space Complexity: O(|S| + |T|)O(∣S∣+∣T∣).
 * 
 * We can use a simple sliding window approach to solve this problem.

In any sliding window based problem we have two pointers. One rightrightright pointer whose job is to expand the current window and then we have the leftleftleft pointer whose job is to contract a given window. At any point in time only one of these pointers move and the other one remains fixed.

The solution is pretty intuitive. We keep expanding the window by moving the right pointer. When the window has all the desired characters, we contract (if possible) and save the smallest window till now.
 */

public class _76_MinimumWindowSubstring_SlidingWindow {
    public static void main(String[] args){
        String ans = minWindow_TwoPointer("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }

    public static String minWindow_TwoPointer(String s, String t) {
        // corner case
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        // construct model
        int minLeft = 0;
        int minRight = 0;
        int min = s.length();
        boolean flag = false;

        Map<Character, Integer> map = new HashMap<>();
        int count = t.length(); // the number of characters that I need to match
        for(char c : t.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);

        // unfixed sliding window, 2 pointers
        int i = 0;
        int j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count--; // if still unmatched characters, then count--
            }

            // if found a susbtring
            while(count == 0 && i <= j){
                // update global min
                flag = true;
                int curLen = j + 1 - i;
                if(curLen <= min){
                    minLeft = i;
                    minRight = j;
                    min = curLen;
                }

                // shrink left pointer
                char leftC = s.charAt(i);
                if(map.containsKey(leftC)){
                    map.put(leftC, map.get(leftC) + 1);
                    if(map.get(leftC) >= 1) count++;
                }
                i++;
            }
            j++;
        }

        return flag == true ? s.substring(minLeft, minRight + 1): "";
    }
}
