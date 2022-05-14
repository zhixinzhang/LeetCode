package DataStructure.Array;
import java.util.*;

//题目含义：给定一个排序数组，两个整数k和x，求数组中距离x最近的k个数字。结果应该有序，距离相同时优先选择较小的数字。
public class _658_FindKClosestElements_BinarySearch{

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-k;
        
        while(start<end) {
            int mid = (start + end)/2;
            if (x - arr[mid] > arr[mid+k]-x)
                start = mid + 1;
            else
                end = mid;
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i=start;i<start+k;i++){
            results.add(arr[i]);
        }
        return results;
    }
}