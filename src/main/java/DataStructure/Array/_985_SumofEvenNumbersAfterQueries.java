package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 6:17 PM
 * Description:
 */


public class _985_SumofEvenNumbersAfterQueries {
    public static void main(String[] args){
        sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
    }
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if(A == null || A.length == 0)
            return null;
        int sum = 0;
        int[] res = new int[queries.length];
        for(int i : A) sum += (i % 2 == 0 ? i : 0);
        for(int i = 0; i < queries.length; i++){
            int index = queries[i][1];
            int prev = A[index];
            int after = queries[i][0] + prev;
            if(prev % 2 == 0){
                if (after % 2 == 0)
                    sum = (sum - prev + after);
                else
                    sum -= prev;
            }else if(after % 2 == 0){
                sum += after;
            }
            res[i] = sum;
            A[index] = after;
        }
        return res;
    }
}
