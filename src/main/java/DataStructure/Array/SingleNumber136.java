package DataStructure.Array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zhang on 2017/3/14.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
//Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
    int result = 0;
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int i = 0;i<nums.length;i++){
        if(hashSet.contains(nums[i])){
            hashSet.remove(nums[i]);
        }else{
            hashSet.add(nums[i]);
        }
    }
      for (Integer a : hashSet){
          return  a;
      }
      return result;
    }


    public static int singleNumber_Map(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        for(int i : map.keySet()){
            if(map.get(i) == 1)
                return i;
        }
        return -1;
    }
    public  static  void main(String[] args){
     int[] nums = {1,2,3,3,2};
        singleNumber_Map(nums);
    }
}
