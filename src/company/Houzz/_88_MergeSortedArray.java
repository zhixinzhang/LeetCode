package company.Houzz;

/**
 * Created by zhang on 2018/1/21.
 */
public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ia = m-1,ib = n-1, ic = m+n-1;
        while(ia>=0 && ib>=0){
            nums1[ic--] = nums1[ia]>nums2[ib]?nums1[ia--]:nums2[ib--];
        }
        while(ib>=0){
            nums1[ic--] = nums2[ib--];
        }
    }
}
