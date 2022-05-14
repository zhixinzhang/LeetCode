package DataStructure.String;

import java.util.HashSet;

/**
 * Created by zhang on 2017/9/22.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
/**把重复的数字删掉
 * */
public class _26_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length ==0) return  0;
        int index = 1;
        for(int i = 1;i<nums.length;i++){
            if (nums[i] != nums[index-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    public static void main(String args[]){
        int[] t = {1,1,1,2,2,3,3};
        int res =  removeDuplicates(t);
    }

}
