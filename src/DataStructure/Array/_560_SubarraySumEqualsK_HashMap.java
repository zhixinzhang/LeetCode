package DataStructure.Array;
import java.util.*;


//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

public class _560_SubarraySumEqualsK_HashMap{
	public static void main(String[] args){
		subarraySum_HM(new int[]{1,1,1}, 2);
	}
	//遍历数组，累加到每一个元素的sum添加到map中，得到0, sum0，sum1，sum2, …., sum(n-1).如果sumj - sumi = k，即可得sum(i+1…j)为k，即计数+1。
	public static int subarraySum_HM(int[] nums, int k) {
    	    if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0, result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                if (preSum.containsKey(sum)) {
                    preSum.put(sum, preSum.get(sum) + 1);
                } else {
                    preSum.put(sum, 1);
                }
            }

            return result;
	    }
	    // 不确定 是否好使
	public static int subarraySum_TwoPointer(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        // 1 6 1 3 5   k = 
        Arrays.sort(nums);
        int left = 0,  right = 0;
        int count = 0, sum = 0;
        for(int i = left ; i<nums.length; i++){
        	left = i;
        	if(left != 0) sum -= nums[left];
        	if(right == 0) sum += nums[right];
        	while(sum < k){
        		right ++;			// 
        		sum += nums[right];
        	}
        	if(sum == k) {
				count++;
				if (right == nums.length - 1)
					break;
			}else  					// sum > k   1 2 4 4  k = 6
        		continue;    
        }
        return count;
    }
}