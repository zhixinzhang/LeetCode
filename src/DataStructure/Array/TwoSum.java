package DataStructure.Array; /**
 * Created by zzx on 16-10-18.
 */

import java.util.*;

/**the code dedcript
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   You may assume that each input would have exactly one solution
 * eg.
 * Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 * */
public class TwoSum {
//best Answer
//    public static int[] twoSum(int[] nums, int target){
//                HashMap<DataStructure.Integer, DataStructure.Integer>pair = new HashMap<DataStructure.Integer, DataStructure.Integer>();
//                int[] result = new int[2];
//                for (int i = 0;i<nums.length;i++){
//                    if (pair.containsKey(nums[i])){
//                        result[0] = pair.get(nums[i]);
//                        result[1] = i;
//                        return result;
//                    }else{
//                        pair.put(target-nums[i], i);
//                    }
//                }
//                return result;
//            }



//my Answer
// 2pointer tiger
//    public  static  int[] myTwoSum(int[] nums, int target){
//        int[] result = new int[2];
//        int start = 0;
//        int end = nums.length-1;
//        Arrays.sort(nums);   nlogn
//        while(start < end){
//            // Case: found
//            if(nums[start] + nums[end] == target){
//
//            }else if(nums[start] + nums[end] > target){
//                end --;
//            }else{
//                start++;
//            }
//        }
//        return  result;
//    }

    public  static  int[] myTwoSum(int[] nums, int target){
        System.out.println("我爱主耶稣");
        HashMap<Integer, Integer>pair = new HashMap<Integer, Integer>();
                int[] result = new int[2];
                for (int i = 0;i<nums.length;i++){
                    if (pair.containsKey(nums[i])){
                        result[0] = pair.get(nums[i]);
                        result[1] = i;
                        return result;
                    }else{
                        pair.put(target-nums[i], i);
                    }
                }
                return result;

    }

    public static void main(String[] args) {

//        int[] nums = {2,7,11,5};
//        int[] nums = {0,4,3,0};
        int[] nums = {0,5,1,0};
        int target = 6;

//        int target = 0;
//        int[] result = twoSum(nums,target);
        int[] myResult = myTwoSum(nums,target);
        System.out.print(myResult);
    }
}
