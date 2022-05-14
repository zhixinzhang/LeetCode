package DataStructure.Array;

import java.util.Arrays;

/**
 * Created by zzx on 11/15/16.
 */
public class PlusOne {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int end = 0;
        if (nums.length == 0) return  1;
        if (0 == nums.length-1){
            if (nums[0]<=0) return 1;
            if (nums[0]>1) return nums[0]-1;
            if(nums[0] ==1) return nums[0]+1;
        }
        int min = nums[nums.length-1];
        for (int i =0;i<nums.length; i++){
            if (nums[i]>0){
                if (min > nums[i]){
                    min  = nums[i];
                }
            }
            if (i == nums.length -1){
                end = nums[i];
                if (min != 1){
                    end = min -1;
                }else {
                    end = end +1;
                }
                break;
            }
            if (nums[i] == nums[i+1]){
                continue;
            }else if (nums[i] >0 && nums[i]+1 != nums[i+1]){
                end = nums[i];
                if (min != 1){
                    end = min -1;
                }else {
                    end = end +1;
                }
                break;
            }
        }
        return  end;
    }



    public static  void main(String[] args){
        int[] nums = {1000,-1};

        int a = firstMissingPositive(nums);
    }

}
