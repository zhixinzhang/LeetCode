package DataStructure.Array;


import java.util.*;

/**
 * Created by zhang on 2017/1/16.
 */
public class SumClosest16 {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    result = sum;
                    minGap = gap;
                }
                if (sum < target) ++j;
                else --k;
            }
        }
        return result;




     // mycode
//        int result = 0;
//        if (nums.length<= 3 ){
//            for (int i :nums){
//                result = result + i;
//            }
//            return result;
//        }
//        Arrays.sort(nums);
//        HashSet<DataStructure.Integer> mySet = new HashSet<DataStructure.Integer>();
//        for(int i = 0;i<nums.length;i++){
//            for(int m = i+1;m<nums.length;m++){
//                for(int k = m+1; k<nums.length;k++){
//                    result = nums[i] + nums[m] +nums[k];
//                    mySet.add(result);
//                    if (result == target) break;
//                }
//            }
//
//        }
//        List<DataStructure.Integer> myList = new DataStructure.ArrayList<>();
//        for (int i : mySet){
//            int val = i - target;
//            myList.add(val);
//        }
//        Collections.sort(myList);
//        int[] num = new int[2];
//        //找到 最靠近target的值   -98 -97
//        for(int i = 0;i<myList.size();i++){
//            result = myList.get(i) + target ;
//          if (myList.get(myList.size()-1) <0){
//              result = myList.get(myList.size()-1) + target ;
//              return  result;
//          }else if(i+1 < myList.size()){
//              if (myList.get(i)<0 && myList.get(i+1)>0){
//                  num[0] = result;
//                  num[1] = myList.get(i+1) + target;
//                  break;
//              }
//          }else if(myList.get(0)>0){
//              result = myList.get(0) + target ;
//              return  result;
//          }
//        }
//        int val = Math.min(num[0],num[1]);
//        result = val + target;
//        return  result;
    }



    public  static  void main(String args[]){

        int[] num = {-1,2,1,-4};
        int target  = 1;
        int result = threeSumClosest(num,target);
        System.out.print(result);
    }
}
