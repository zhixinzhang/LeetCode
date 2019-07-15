package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzx on 11/10/16.
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1]
 */
//解析  logn  用二分法查找
public class SearchforaRange34 {
    public  static  int[] searchRange(int[] nums, int target) {
        //find the fist point
        int lower = lower(nums, target,0);
        int upper = upper(nums,target,0);

        if (lower == nums.length || nums[lower] != target)
            return new int[]{-1, -1};
        else
            return new int[]{lower, upper-1};

    }

    static int  lower (int[] nums,int target,int first){
        int last = nums.length;
        while (first != last){
            int mid = first + (last - first)/2 ;
            if (target > nums[first] ){
                first = ++mid;
                last = mid;
            }
        }
        return  first;
    }
    static int upper (int[] nums,int target,int first){
        int last = nums.length;
        while (first != last){
            int mid = first + (last - first)/2;
            if (target >= nums[mid]){
                first = ++mid;
                last = mid;
            }
        }
        return  first;
    }


//    public static int[] searchRange(int[] nums, int target) {
//
//        List<DataStructure.Integer> list = new DataStructure.ArrayList<DataStructure.Integer>();
//        for (int i = 0;i<nums.length;i++){
//            if (nums[i] == target){
//                if (list.size() ==2){
//                    list.remove(list.get(1));
//                }
//                list.add(i);
//            }
//        }
//        if (list.size() == 0){
//            int[] result  = {-1,-1};
//
//            return result;
//
//        }else if (list.size()==1){
//
//            int[] result  = {list.get(0),list.get(0)};
//
//            return result;
//        }else {
//            int[] result  = new int[list.size()];
//            for (int a =0;a<list.size();a++){
//                result[a] = list.get(a);
//            }
//            return result;
//        }
//    }





    public static void main(String args[]){
        int[] nums = {1,1,1};
        int target = 1;
        int[] answer = searchRange(nums,target);
        System.out.print("");
    }
}
