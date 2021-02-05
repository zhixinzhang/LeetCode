package Company.PG;

import java.util.Arrays;

/**
 * Created by zhang on 2018/1/19.
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 You need to return the number of important reverse pairs in the given array.
 */
//O(nlogn)
// 归并排序 左右对比 一直到整个
public class _493_ReversePairs_MergeSort {
    public static void main(String[] args){
        reversePairs(new int[]{2,4,3,5,1});
    }
    public static int ret;
    public static int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length-1);
        return ret;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(nums, left, middle);
        mergeSort(nums,middle+1, right);

        //count elements
        int count = 0;
        for (int l = left, r = middle+1; l <= middle;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }

        //sort
        Arrays.sort(nums, left, right + 1);
    }
}
