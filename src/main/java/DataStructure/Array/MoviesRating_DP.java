package DataStructure.Array;

/**
 * Created by zhang on 2018/1/15.
 */
public class MoviesRating_DP {
    public static void main(String[] args){
//        movieRat(new int[]{-1,-2,-3,-4,-5});
        movieRat(new int[]{-1,-3,5});
//        movieRat(new int[]{1,2,-3,2,1});
    }
//    int res = 0;
//        if(arr == null || arr.length ==0) return res;
//    int len = arr.length;
//    int[] take  = new int[len];
//    int[] skip = new int[len];
//    take[0] = arr[0];
//    skip[0] = 0;
//    // 9  -1  -3  4  5
//
//        for(int i = 1; i<len;i++){
//        take[i] = Math.max(take[i-1],skip[i-1]) + arr[i-1];
//        skip[i-1] = take[i-1];
//        res = Math.max(res,take[i]);
//
//    }
//        return Math.max(skip[len],take[len]);
    public static int movieRat(int[] arr){
        int len = arr.length;
        int[] take = new int[len+1];
        int[] skip = new int[len+1];
        take[0] = arr[0];
        skip[0] = 0;
        // -1 -3 5
        /** i  1
         *
         * */
        int jumpMax = 0;
        int noJumpMax = arr[0];
        for(int i = 1;i<len;i++) {
            int next = Math.max(noJumpMax + arr[i] ,arr[i] + jumpMax);
            jumpMax = noJumpMax;
            noJumpMax = next;

            int a = 0;
        }
        return Math.max(noJumpMax,jumpMax);


    }
}
