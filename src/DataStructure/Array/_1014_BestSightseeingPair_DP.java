package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/19/19
 * Time: 7:13 PM
 * Description:
 */


public class _1014_BestSightseeingPair_DP {
    public static void main(String[] args){
        maxScoreSightseeingPair(new int[]{1, 2, 5, 10, 11});
    }
    public static int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE, index = 0;
        for(int i = 1; i < A.length; i++){
            max =  Math.max(max, A[i] + index + A[index] - i);
            index = A[i] + i > A[index] + index ? i : index;
        }
        return max;
    }
}
