package google.Array;

/**
 * Created by zhang on 2018/6/3.
 */
public class _821_ShortestDistancetoaCharacter {
    public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }
    public static void main(String[] args){
        shortestToChar("loveleetcode",'e');
        // loveleetcode    11 12 13
        //
    }
}
