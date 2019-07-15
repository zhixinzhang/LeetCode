package company.zillow.Array;

/**
 * Created by zhang on 2018/9/27.
 * 一个美国妹子,普通数组, 取末尾数字x, 重排数组 使得左边小于x, 右边大于等于x
 follow up, 用此方法对数组排序
 https://www.geeksforgeeks.org/quick-sort/
 */
public class QucikSort {
    public static void main(String[] args){
        int[] arrs = new int[]{4,8,3,6,1,5};
        partition(arrs,0,arrs.length-1);
    }
    /* This function takes last element as pivot,
     places the pivot element at its correct
     position in sorted array, and places all
     smaller (smaller than pivot) to left of
     pivot and all greater elements to right
     of pivot */
   public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void sort(int[] arr, int low , int high){
        if (low < high){
            int idx = partition(arr, low, high);
            sort(arr, low, idx-1);
            sort(arr,idx+1, high);
        }
    }

    public static void swap(int[] arrs, int l, int r){
        int temp = arrs[r];
        arrs[r] = arrs[l];
        arrs[l] = temp;
    }
}
