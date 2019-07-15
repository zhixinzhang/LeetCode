package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/20/19
 * Time: 7:03 PM
 * Description:
 */

// maintain a sliding window  K + length
public class _1004_MaxConsecutiveOnes3_TwoPointer {
    public int MaxConsecutiveOnes(int[] A, int k){
        int l = 0, r, ans = Integer.MIN_VALUE;
        for (r = 0; r < A.length; r++){
            if (A[r] == 0) k--;
            while (k < 0){
                if (A[l] == 0) k++;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
