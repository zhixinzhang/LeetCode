package google;

/**
 * Created by zhang on 2018/5/16.
 */
public class _809_ExpressiveWords_twoPointer {
    public static int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i, j; // S & w's pointers.
            for (i = 0, j = 0; i < S.length(); ++i) {
                if (j < w.length() && S.charAt(i) == w.charAt(j)) { // matches, w pointer j 1 step forward to move together with i.
                    ++j;
                }else if (i > 0 && S.charAt(i - 1) == S.charAt(i) && i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) { // previous, current & next are same.
                    ++i; // S pointer 1 step forward, attempt to traverse the repeated chars.
                }else if (!(i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i - 2))) { // current & previous 2 are not same.
                    break; // No match.
                }
            }
            if (i == S.length() && j == w.length()) { ++count; } // both pointers reach ends.
        }
        return count;
    }
    public static void main(String[] args){
        expressiveWords("heeellooo",new String[]{"hello", "hi", "helo"});
    }
}
