package DataStructure.String;

//s = "ABAB"   k = 2
//s = "AABABBA", k = 1
//sliding window  formula ---  window.length - same letter num <= k  right point ++ else left point ++
//https://www.cnblogs.com/reboot329/p/5968393.html

public class _424_LongestRepeatingCharacterReplacement{
    public static void  main(String[] args){
        characterReplacement("AABABBA",1);


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