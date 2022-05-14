package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/9/19
 * Time: 4:16 PM
 * Description:
 */


public class _941_ValidMountainArray_BS {
    public static void main(String[] args){
        findPeak(new int[]{1, 2, 6, 7, 4, 1});
    }
    public boolean validMountainArray(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }

    public static boolean validBS(int[] A){
        if (A.length < 3)
            return false;
        int lo = 0, hi = A.length-1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if( mid <= A.length -2 && mid - 1 >= 0 && A[mid] > A[mid -1] && A[mid] < A[mid + 1])
                return true;
            if (A[mid] > A[mid - 1])
                lo = mid;
            if (A[mid] == A[mid - 1])
                lo = mid + 1;
            if(A[mid] < A[mid - 1])
                hi = mid - 1;
        }
        return false;
    }

    // 1 2 6 7 4 1
    public static int findPeak(int[] nums){
        if (nums == null || nums.length < 3)    return -1;
        int l = 0, r = nums.length-1, mid = 0;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return nums[mid];
            if (nums[mid] > nums[mid - 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return nums[l];
    }

}
