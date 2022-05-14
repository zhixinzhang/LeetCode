package DataStructure.Array;


public class _673_NumberofLongestIncreasingSubsequence_DP{
	public static void main(String[] args){
		findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
	}
		//[1,3,5,4,7]   dp
	   public static int findNumberOfLIS(int[] nums) {
		   if(nums == null || nums.length == 0) return 0;
		   int n = nums.length, max_len = 0;
		   int[] len = new int[n];
		   int[] cnt = new int[n];
		   for (int i = 0; i < n; ++i) {
			   len[i] = 1;
			   cnt[i] = 1;
			   for (int j = 0; j < i; ++j) {
				   if (nums[i] > nums[j]) {
					   if (len[i] == len[j] + 1) cnt[i] += cnt[j];
					   else if (len[i] < len[j] + 1) {
						   len[i] = len[j] + 1;
						   cnt[i] = cnt[j];
					   }
				   }
				   max_len = Math.max(max_len, len[i]);
			   }
		   }

		   int res = 0;
		   for (int i = 0; i < n; ++i) {
			   if (len[i] == max_len) res += cnt[i];
		   }
		   return res;
    	}



}