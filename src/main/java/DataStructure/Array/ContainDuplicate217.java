package DataStructure.Array;

import java.util.HashSet;

/**
 * Created by zhang on 2017/1/31.
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 */
public class ContainDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        HashSet hashSet = new HashSet();
        for (int i=0;i<nums.length;i++){
            if (!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }else{
                result = true;
                break;
            }
        }
        return  result;
    }




    public static void main (String args[]){
        int[] nums = {1,1,1,2,3,4};
        containsDuplicate(nums);


    }
}
