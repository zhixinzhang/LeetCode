package google.DP;

/**
 * Created by zhang on 2018/6/30.
 * https://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 */

/**
 * Given a 2D array, find the maximum sum subarray in it
 */
public class _304_RangeSum_follow_DP {
    public static void main (String[] args) throws java.lang.Exception {
        findMaxSubMatrix(new int[][] {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        });
    }
    /**
     * To find and print maxSum, (left, top),(right, bottom)
     */
    public static void findMaxSubMatrix(int[][] a){
        int cols = a[0].length;
        int rows = a.length;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int[] currentResult;
        for (int leftCol = 0; leftCol < cols; leftCol++ ){
            int[] tmp = new int[rows];
            for (int rightCol = leftCol; rightCol < cols; rightCol ++){
                for (int i = 0; i<rows;i++){
                    tmp[i] += a[i][rightCol];
                }
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum){
                    maxSum = currentResult[0];
                    left = leftCol;
                    top = currentResult[1];
                    right = rightCol;
                    bottom = currentResult[2];
                }
                int c = 0;
            }
        }
        System.out.println("MaxSum: " + maxSum +
                ", range: [(" + left + ", " + top +
                ")(" + right + ", " + bottom + ")]");
    }
    /**
     * To find maxSum in 1d array
     *
     * return {maxSum, left, right}
     */
    public static int[] kadane(int[] a){
        //result[0] = maxSum result[1] = start result[2] = end
        int[] result = new int[]{Integer.MIN_VALUE,0,-1};
        int curSum = 0;
        int localStart = 0;
        for (int i = 0; i < a.length; i++){
            curSum += a[i];
            if (curSum < 0){
                curSum = 0;
                localStart = i+1;
            }else if (curSum > result[0]){
                result[0] = curSum;
                result[1] = localStart;
                result[2] = i;
            }
        }
        // if all number is negative
        if (result[2] == -1){
            result[0] = 0;
            for (int i = 0; i<a.length; i++){
                if (a[i] > result[0]){
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
        return result;
    }
}
