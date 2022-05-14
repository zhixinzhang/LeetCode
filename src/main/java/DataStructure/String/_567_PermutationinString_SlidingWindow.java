package DataStructure.String;
import java.util.*;

// sliding window + int[]   time complexity O(n) spance O(n)

public class _567_PermutationinString_SlidingWindow{
public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] count = new int[26];				//ab  // eidbaooo
        for (int i = 0; i < len1; i++) {			
            count[s1.charAt(i) - 'a']++;	//[11...]
            count[s2.charAt(i) - 'a']--;	//[...-1...-1]
        }
        if (allZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;		// ***
            if (allZero(count)) return true;
        }
        
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}