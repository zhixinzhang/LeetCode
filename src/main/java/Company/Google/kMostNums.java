package Company.Google;

/**
 * Created by zhang on 2017/12/3.
 * http://blog.csdn.net/kangkanglou/article/details/5726864
 */
public class kMostNums {
	public int[] findKNums(int[] nums, int k){
		// 2 1 3 4 5 6 7 8
		if (nums == null || nums.length <= k) {
			return nums;
		}
		int[] maxRes = new int[k];

		for (int i = 0;i<k ;i++ ) {
				maxRes[i] = nums[i];
		}


		return maxRes;
	}
}
