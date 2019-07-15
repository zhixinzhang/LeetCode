package DataStructure.String;
import java.util.*;
//非常经典 slid window two pointer 
//https://www.youtube.com/watch?v=lFG63nc9zrQ
//O(n) O(n)
public class _438_FindAllAnagramsinaString_SlidingWindow{
    public static void main(String[] args){
        findAnagrams("cbaefgbabacd","abc");
    }
    // usr char[26] to record string p each char freq abc [1,1,1,0,0,0....] 
    // two pointer start and end pointer 
    //start = 0 and end = 0
    // when end - start == String p.length() check char[26] if all freq == 0 its mean we found anargam
    // 1. for loop sting s from 0 to s.length
    // just if start - end == p.length
    public static List<Integer> findAnagrams(String s, String p) {
            int[] chars = new int[26];
    List<Integer> result = new ArrayList<>();

    if (s == null || p == null || s.length() < p.length())
        return result;
    for (char c : p.toCharArray())
        chars[c-'a']++;

    int start = 0, end = 0, count = p.length();
    // Go over the string
    while (end < s.length()) {
    	// start = 0 and 
        // If the char at start appeared in p, we increase count

        if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
            count++;
        System.out.println(String.valueOf(chars));
        // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
        if (--chars[s.charAt(end++)-'a'] >= 0)
            count--;
        if (count == 0)
            result.add(start);
    }
    
    return result;
    }
	
}