package DataStructure.Array;

/**
 * Created by zhang on 2017/10/24.
 */
/* k = 6
*  1 2 3
*  2 4 6
*  3 6 9
*  二分法 先找到中点 然后根据 0到中点 有多少个比中点小的值 跟k'对比
* */
public class _668_KthSmallestNumberinMultiplicationTable_BS {
    public static int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n +1;
        while (start < end) {
            int mid = start + (end - start)/2;
            int count = getCount(mid, m, n);
            if (count >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static int getCount(int mid, int m, int n){
        int count = 0;
        for (int i = 1 ; i<= m; i++){
            count += Math.min(mid/i,n);
        }
        return count;
    }

    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int k = 6;
        int a = findKthNumber(m,n,k);
    }
}
