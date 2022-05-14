package DataStructure.Array;
import java.util.*;

public class _169_MajorityElement_MooreVote{
	// 1 2 1 2 3 3 3 3 3
		    public int majorityElement(int[] nums) {
		    		int count = 0, ret = 0;
					for (int num : nums) {
						if(count == 0){
							ret = num;
						}
						if (num != ret) {
								count--;
							}else{
								count++;
							}	
					}
					return ret;

			}

		public int majorityElement_HashMap(int[] nums) {
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
}