package Company.uber;

import java.util.Arrays;

/**
 * Created by zhang on 2018/9/9.
 */
public class _findElement_in_array_BS_follup {
    public static void main(String[] args){
        int c = find_index(new int[]{1,4,5,2,3,6,8}, 5);
        //follow up 有多个重复数据 返回第一个index
//        int b = find_index_duplicate(new int[]{1,3,4,5,6}, 2);
        //follow up 有多个重复数据 返回第一个index 和最后一个index
        int idxL = find_duplicate_left(new int[]{1,2,2,2,2,2,3,4,5,6}, 2);
        int idxR = find_duplicate_right(new int[]{1,2,2,2,2,2,3,4,5,6}, 2);
        System.out.println(c);
    }
    public static int find_duplicate_right(int[] arr, int target) {
        int n = arr.length-1;
        int l = 0, r = n, mid;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (arr[mid] == target){
                if (arr[mid+1] != target){
                    return mid;
                }else {
                    l = mid+1;
                }
            }
            if (arr[mid] > target)
                r = mid -1;
            else if (arr[mid] < target)
                l = mid+1;

        }
        return l;
    }


    public static int find_duplicate_left(int[] arr, int target){
        int n = arr.length-1;
        int l = 0, r = n, mid;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (arr[mid] == target){
                if (arr[mid - 1] != target)
                    return mid;
                else
                    r = mid-1;
            }
            if (arr[mid] > target)
                r = mid -1;
            else if (arr[mid] < target)
                l = mid+1;

        }
        return l;
    }


    public static int find_index(int[] arr, int target){
        Arrays.sort(arr);
        // 1234568
        int c = Arrays.binarySearch(arr, target);
        if (arr == null || arr.length == 0)
            return -1;
        int l = 0, r = arr.length-1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static int find_index_duplicate(int[] arr, int target){
        Arrays.sort(arr);
        if (arr == null || arr.length == 0 || arr[0] > target || arr[arr.length-1] < target)
            return -1;
        int l = 0, r = arr.length-1, mid = 0;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (arr[mid] == target){
                if (arr[mid - 1] != target)
                    return mid-1;
                else
                    r = mid-1;
            }
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
