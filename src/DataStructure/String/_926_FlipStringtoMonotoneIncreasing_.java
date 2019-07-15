package DataStructure.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/13/19
 * Time: 12:55 PM
 * Description:
 *
 * Algorithm:
 *
 * Skip 0's until we encounter the first 1.
 * Keep track of number of 1's in onesCount (Prefix).
 * Any 0 that comes after we encounter 1 can be a potential candidate for flip. Keep track of it in flipCount.
 * If flipCount exceeds oneCount - (Prefix 1's flipped to 0's)
 * a. Then we are trying to flip more 0's (suffix) than number of 1's (prefix) we have.
 */

// 0 0 1 1 0 1 0  -> 0 0 0 0 0 0 0 / 0 0 1 1 1 1 1
public class _926_FlipStringtoMonotoneIncreasing_ {
    public int minFlipsMonoIncr(String S) {
        if(S == null || S.length() == 0)
            return 0;
        char[] c = S.toCharArray();
        int flip = 0;
        int oneCount = 0;
        for (int i = 0; i < c.length;i++){
            if (c[i] == '0'){
                if (oneCount == 0) continue;
                flip++;
            }else
                oneCount++;

            flip = Math.min(flip, oneCount);
//            if (flip > oneCount){
//                flip= oneCount;
//            }
        }
        return flip;
    }
}
