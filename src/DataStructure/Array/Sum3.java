package DataStructure.Array;

import java.util.*;

/**
 * Created by zzx on 10/31/16.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Sum3 {
    //best code
//    public static List<List<DataStructure.Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<DataStructure.Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length-2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//                        lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) lo++;
//                    else hi--;
//                }
//            }
//        }
//        return res;
//    }
    //mycode
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> test = new ArrayList<Integer>();
        if (nums.length <3){
            return  result;
        }
        for(int i=0;i<nums.length;i++){
            for(int m=i+1;m<nums.length;m++){
                for(int h = m+1;h<nums.length;h++){
                    if (nums[i]+nums[m]+nums[h] == 0){
                        List<Integer> endNum = new ArrayList<Integer>();
                        endNum.add(nums[i]);
                        endNum.add(nums[m]);
                        endNum.add(nums[h]);
                        Collections.sort(endNum);
                        if (!result.contains(endNum)){
                            result.add(endNum);
                        }
                    }
                }
            }
        }
        return  result;
    }


//    public static List<List<DataStructure.Integer>> threeSum(int[] nums) {
//        List<List<DataStructure.Integer>> result = new DataStructure.ArrayList<List<DataStructure.Integer>>();
//        Arrays.sort(nums);
//        HashSet<DataStructure.Integer>  mySet = new HashSet<DataStructure.Integer>();
//        for (int i:nums){
//            mySet.add(i);
//        }
//             // -4,-1 ,-1,0,1,2,
//        for(int i = 0;i<nums.length;i++){
//           for(int k = nums.length;k>0;k--){
//               int val = nums[i] + nums[k];
//               if (){
//
//               }
//           }
//        }
//
//
//
//
//
//        return  result;
//    }

    public  static  void main(String args[]){

        int[] num = {-1, 0, 1, 2, -1, -4};
        // -1 -1 -4 0 1 2
//        int[] num = {};

        List<List<Integer>> result = threeSum(num);
        System.out.print(result);
    }



}
