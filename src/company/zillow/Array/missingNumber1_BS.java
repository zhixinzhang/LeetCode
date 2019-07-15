package company.zillow.Array;

/**
 * Created by zhang on 2018/9/26.
 */
public class missingNumber1_BS {
    public static void main(String[] args){
        findNumber(new int[]{1,2,3,4,5,6,7,8,9}, 10);  //4
    }

    // Binary search
    public static int findNumber(int[] arr, int n){
        // test case miss 5 idx in 4 should be 6 [0 1 2 3 4 5] -> [0 2 3 4 5]
        int left = 0, right = arr.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(arr[mid] == mid)         // no miss number
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
