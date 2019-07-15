package DataStructure.Array;
import java.util.*;

public class _532_KdiffPairsinanArray{

	//O(nlogn)
	public int findPairs(int[] nums, int k) {
	    int ans = 0;
	    Arrays.sort(nums);
	    for (int i = 0, j = 0; i < nums.length; i++) {
	        for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) ;
	        if (j < nums.length && (long) nums[j] - nums[i] == k) ans++;
	        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
	    }
	    return ans;
	}

	    public int findPairs_map(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}