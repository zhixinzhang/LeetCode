package DataStructure.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2017/1/30.  easy
 */
public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        int result = 0;
        if(nums.length == 1 ){
            return  result = nums[0];
        }        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0;i<nums.length;i++){

            if(!hashMap.containsKey(nums[i])){
                int numTmp = 1;
                hashMap.put(nums[i],numTmp);
            }else{
                int numTmp =  hashMap.get(nums[i]);
                numTmp = numTmp+1;
                hashMap.put(nums[i],numTmp);
                if (numTmp > nums.length/2){
                    return  result = nums[i];
                }
            }
        }
        return  result;
    }
//best answer
//    public  int majorityElement(int[] nums){
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }


    public  static  void main(String[] args){
        int[] nums = {1,1,1,1,2,3,4};
        majorityElement(nums);
    }
}
