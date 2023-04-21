package DataStructure.Array;

/**
 * Created by zhang on 2018/2/9.
 */
// 1 2   5  6      2  4
//1 2 2 4 5 6 -- 3
// basic idea use binary search to find kth num
//if odd return k or even return (k+k-1)/2
    //https://www.cnblogs.com/duanqiong/p/4415049.html
    //https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46
public class _4_MedianofTwoSortedArrays_BinarySearch_DivideConquer {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];

        int i=0, j=0, k=0;

        while (i<=n1 && j<=n2) {
            if (i == n1) {
                while(j<n2) new_arr[k++] = nums2[j++];
                break;
            } else if (j == n2) {
                while (i<n1) new_arr[k++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }

        if (n % 2 == 0) 
            return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
        else 
            return new_arr[n/2];
    }
}
