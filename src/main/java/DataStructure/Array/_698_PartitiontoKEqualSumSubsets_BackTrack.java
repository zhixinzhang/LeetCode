package DataStructure.Array;
import java.util.*;


//https://www.youtube.com/watch?v=8XEcEYsG6Ck
public class _698_PartitiontoKEqualSumSubsets_BackTrack{

	 public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0) return true;
        int sum = 0;
        for(Integer i : nums){
            sum += i;
        }
        if(sum % k != 0) return false;
        int subSum = sum / k;
        // special case  nums[i] == subSum
        Arrays.sort(nums);         
        int index = nums.length - 1;
        while(index >= 0 && nums[index] == subSum){
            index--;
            k--;
        }
        return partition(nums,new int[k],index,subSum);
        
    }
    private boolean partition(int[] nums, int[] subSet, int index, int subSum){
        // return situation
        if(index < 0) return true;
        int curNum = nums[index];
        for(int i = 0; i<subSet.length;i++){
            if(subSet[i] + curNum <= subSum){
                subSet[i] += curNum;
                if(partition(nums,subSet,index-1,subSum)){
                    return true;
                }
                subSet[i] -= curNum;
            }
        }
        return false;
    }
}