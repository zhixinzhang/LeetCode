package company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/11/19
 * Time: 7:52 PM
 * Description:
 *
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * O(n) time O(1) space
 */


public class _905_SortArrayByParity_twopointer {
    public static void main(String[] args){
        sortArrayByParity(new int[]{1,0,3});
    }
    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0)
            return A;

        for (int i = 0, j = A.length-1; i < j; i++, j-- ){
            while (i < j && A[i] % 2 == 0){
                i++;
            }
            if (i >= j) return A;
            while (j > i && A[j] % 2 != 0){
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}
