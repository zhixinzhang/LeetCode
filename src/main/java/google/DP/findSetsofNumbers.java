//
//
//
//public class findSetsofNumbers{
//
//	public int solution(int[] nums, int target){
//		// 2 4 6 10  target 16
//		int n = nums.length;
//		int[] dp = new int[n];
//		dp[0] = 0;
//		HashSet<String> hs = new HashSet<>();
//
//		return dp(nums, target,0, hs);
//
//	}
//
//	public int dp(int[] nums, int target, int index, HashSet<String> hs){
//		String key = String.valueOf(target) + ":" + String.valueOf(index);
//		if (target < 0) {
//			return 0;
//		}
//		if (target == 0) {
//			return 1;
//		}
//	}
//
//
//
//}