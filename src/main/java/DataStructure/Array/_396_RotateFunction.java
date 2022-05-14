package DataStructure.Array;

/**
 * Created by zhang on 2018/5/2.
 */
public class _396_RotateFunction {
    public static int maxRotateFunction(int[] A) {
        int max = Integer.MIN_VALUE;
        if(A == null || A.length == 0)
            return 0;
        for(int i = 0; i<A.length; i++){
            int index = A.length - i;
            int cur = 0;
            int curIndex = 0;
            int count = 0;
            for(int j = index; j<A.length; j++){
                cur += A[j] * curIndex;
                curIndex++;
                count++;
            }
            for (int j = 0; j < A.length - count;j++){
                cur += A[j] * curIndex;
                curIndex++;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
    public static void main(String[] args){
        maxRotateFunction(new int[]{-2147483648,-2147483648});
    }
}
