package company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/18/19
 * Time: 8:55 PM
 * Description:
 */


public class _977_SquaresofaSortedArray_twopointer {
    public static void main(String[] args){
        sortedSquares(new int[]{-4,-1,0,3,10});
    }
    public static int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0)
            return A;
        int l = 0, r = A.length - 1, index = A.length-1;
        int[] res = new int[A.length];
        while(l <= r){
            if(Math.abs(A[l]) >= Math.abs(A[r])){
                res[index] = A[l] * A[l];
                l++;
            }else{
                res[index] = A[r] * A[r];
                r--;
            }
            index--;
        }
        return res;
    }
}
