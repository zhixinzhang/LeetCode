package google.Array;

/**
 * Created by zhang on 2018/6/20.
 * quick select
 * https://www.geeksforgeeks.org/quickselect-algorithm/
 */
public class _215_KthLargestElementinanArray{
        public int findKthLargest(int[] a, int k) {
            int n = a.length;
            int res = quickSelect(a,0, n - 1, n - k + 1);
            return a[res];
        }
    // return the index of the kth smallest number
    public int quickSelect(int[] a, int lo, int hi, int k){
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if (m == k)     return i;
            // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k);
            // pivot is too small, so it must be on the right
        else            return quickSelect(a, i + 1, hi, k - m);
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
