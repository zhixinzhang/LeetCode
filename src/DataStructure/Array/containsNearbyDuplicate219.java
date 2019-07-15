package DataStructure.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2017/1/31.
 * Given an array of integers and an integer k, find out whether there are two distinct
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class containsNearbyDuplicate219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                int perIndex = hashMap.get(nums[i]);
                int gap = i - perIndex;
                min = Math.min(min,gap);
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return  min<=k;
    }



    public static  void main(String args[]){
        int[] nums = {1,0,1,1};
        int k = 1;
        containsNearbyDuplicate(nums,k);
    }
}
