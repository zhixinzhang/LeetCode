package Company.PayPal.OA;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/thread-952004-1-1.html
 * 先把array sort然后直接看俩个相邻的数最小差值，然后再遍历array返回满足差为最小差值的数
python注意如果用上面的python 题解没有过是因为output和他想要的不一样。需要遍历一下我们创建的list “[[1,2],[3,4]]"把它拆分成题目需要的output形式，就能过。
 * 
*/
public class _ClosestNumber_ {
    static void printMinDiffPairs(int arr[], int n) {
        if (n <= 1)
        return;
        
        // Sort array elements
        Arrays.sort(arr);
        
        // Compare differences of adjacent
        // pairs to find the minimum difference.
        int minDiff = arr[1] - arr[0];
        for (int i = 2; i < n; i++)
        minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        
        // Traverse array again and print all pairs
        // with difference as minDiff.
        for ( int i = 1; i < n; i++)
        {
            if ((arr[i] - arr[i-1]) == minDiff)
            {
            System.out.print("(" + arr[i-1] + ", "
                            + arr[i] + ")," );
            }                   
        }
    }

      // Driver code
  public static void main (String[] args){
    int arr[] = {5, 3, 2, 4, 1};
    int n = arr.length;
    printMinDiffPairs(arr, n);
  }
}
