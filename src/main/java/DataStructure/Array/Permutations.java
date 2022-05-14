package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzx on 11/14/16.
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],   123
 [1,3,2],   213
 [2,1,3],   231
 [2,3,1],   132
 [3,1,2],
 [3,2,1]
 ]
 */

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numList = new ArrayList<List<Integer>>();
        for (int i = 0;i<nums.length;i++){
            helper(nums,numList,i);
        }
        return numList;
    }



     public static void  helper(int[] nums,List<List<Integer>> numList,int index){
         List<Integer> num = new ArrayList<Integer>();

         for(int i=0; i<nums.length;i++) {
             if(index >= nums.length-1) break;
             int trNum = nums[i];
             nums[i] = nums[index];
             nums[index] = trNum;
             for(int n=0;n<nums.length;n++){
                 num.add(nums[n]);
             }
             if(!numList.contains(num)) numList.add(num);
             index ++;
             if(index <= nums.length-1){
                 helper(nums,numList,index);
             }
         }
        }

    public  static  void  main(String[] args){
        int[] n = {1,2,3};
        List<List<Integer>> answer = permute(n);
        System.out.print("");
    }
}
