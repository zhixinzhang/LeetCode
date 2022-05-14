package DataStructure.Array;


public class _506_RelativeRanks_sort{

	    public String[] findRelativeRanks(int[] nums) {
	    	String[] result = new String[nums.length];
	    	if(nums == null || nums.length == 0) return result;
	    	int[] index = new int[nums.length];
//        	Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        	for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
	    }	
}