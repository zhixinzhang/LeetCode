package DataStructure.Array;
import java.util.*;

public class _747_LargestNumberAtLeastTwiceofOthers_Sort{
	public int dominantIndex(int[] nums) {
        
        int maxnum=0, second=0, maxidx=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > maxnum) {
                second = maxnum;
                maxnum = nums[i];
                maxidx = i;
            }
            else {
                if (nums[i] > second) {
                    second = nums[i];
                }
            }
        }
        if (maxnum >= 2*second) {
            return maxidx;
        }
        return -1;
        
    }


	    public int dominantIndex_Sort(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        if(nums.length == 1) return 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int len = nums.length;
        if(temp[len-1] >= temp[len-2]*temp[len-2]){
            for(int i = 0; i<nums.length;i++){
                if(temp[len-1] == nums[i])
                    return i;
            }
        }else{
            return -1;    
        }
        return -1;
    }
}