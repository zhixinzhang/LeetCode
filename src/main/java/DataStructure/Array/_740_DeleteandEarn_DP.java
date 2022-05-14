package DataStructure.Array;


public class _740_DeleteandEarn_DP{

	    public int deleteAndEarn(int[] nums) {
	    	int[] values = new int[10001];
	    	for(int num : nums){
	    		values[num] += num;
	    	}
	    	int curMax = 0;
	    	int preMax = 0;
	    	for(int i = 0; i<values.length;i++){
	    		int temp = curMax;
	    		curMax = Math.max(preMax + values[i],curMax);
	    		preMax = curMax;
	    	}
	    	return curMax;
	    }
}