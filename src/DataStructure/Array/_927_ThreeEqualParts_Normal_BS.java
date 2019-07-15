package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/7/19
 * Time: 3:05 PM
 * Description:
 */


public class _927_ThreeEqualParts_Normal_BS {
    public int[] threeEqualParts(int[] A) {
        int numOne = 0;
        for (int i: A){
            if (i==1) numOne++;
        }

        int[] noRes = {-1, -1};
        if (numOne == 0) return new int[]{0,2};
        if (numOne%3 != 0) return noRes;

        //find index of starting 1 of third string
        int idxThird=0;
        int temp = 0;
        for (int i = A.length-1; i>=0; i--){
            if (A[i]==1){
                temp++;
                if (temp == numOne / 3){
                    idxThird = i;
                    break;
                }
            }
        }

        int res1 = findEndIdx(A, 0, idxThird);
        if (res1<0) return noRes;

        int res2 = findEndIdx(A, res1+1, idxThird);
        if (res2<0) return noRes;

        return new int[]{res1, res2+1};
    }

    //right is the pattern to compare to.
    //return EndIdx of left pattern that matches right side.
    private int findEndIdx(int[] A, int left, int right){
        while (A[left]==0) left++;
        while (right < A.length){
            if (A[left]!=A[right]) return -1;
            left++;
            right++;
        }
        return left-1;
    }
}
