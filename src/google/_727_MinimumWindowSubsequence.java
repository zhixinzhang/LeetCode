package google;

/**
 * Created by zhang on 2018/5/20.
 * S = "abcdebdde", T = "bde"
 Output: "bcde"
 */
public class _727_MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        String res = "";
        int maxLen = Integer.MAX_VALUE;
        StringBuilder or = new StringBuilder(T);
        if (S.length() < T.length())    return res;
        int left = S.indexOf(T.charAt(0)), right = left;
        if (left == -1) return "";
        while (right < S.length()){
            if (S.charAt(right) == or.charAt(0)){
                if (or.length() == T.length())
                    left = right;
                or.deleteCharAt(0);
            }
            right++;

            if (or.length() == 0){
                if(right - left+1 < maxLen){
                    maxLen = right - left+1;
                    res = S.substring(left,right);
                }
                or = new StringBuilder(T);
                left++;
                right = left+1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        minWindow("cnhczmccqouqadqtmjjzl","cm");
//        minWindow("abcdebdde","bde");
    }
}
