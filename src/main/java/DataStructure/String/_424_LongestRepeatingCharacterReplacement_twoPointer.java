package DataStructure.String;

//s = "ABAB"   k = 2
//s = "AABABBA", k = 1
//sliding window  formula ---  window.length - same letter num <= k  right point ++ else left point ++
//https://www.cnblogs.com/reboot329/p/5968393.html

public class _424_LongestRepeatingCharacterReplacement_twoPointer {
    public static void  main(String[] args){
        characterReplacement("AABABBA",1);
    }

    public int characterReplacement_two(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


    public static int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;
        int[] map = new int[26];
        int most = ++map[s.charAt(0) - 'A'];
        int res = 1;
        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            most = Math.max(most,++map[s.charAt(right) - 'A']);
            if (right - left + 1 > most + k) {
                map[s.charAt(left++) - 'A']--;
            } else {
                res = Math.max(res,right - left + 1);
            }
        }
        
        return res;
    }
}