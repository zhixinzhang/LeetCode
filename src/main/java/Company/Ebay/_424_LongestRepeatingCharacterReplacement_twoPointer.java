package Company.Ebay;


//s = "ABAB"   k = 2
//s = "AABABBA", k = 1
//sliding window  formula ---  window.length - same letter num <= k  right point ++ else left point ++
// O(N) time O(1) space
//https://www.cnblogs.com/reboot329/p/5968393.html

public class _424_LongestRepeatingCharacterReplacement_twoPointer {
    public static void  main(String[] args){
        characterReplacement_SlidingWindow("AABABBA",1);
    }

    public static int characterReplacement_SlidingWindow(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
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